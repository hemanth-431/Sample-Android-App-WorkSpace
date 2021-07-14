package com.klef.includeklu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.multidex.MultiDex;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registor extends AppCompatActivity {
    private TextInputEditText name;
    private TextInputEditText mail;
    private TextInputEditText pass;
    private Button button;
    private Toolbar toolbar;
    private DatabaseReference database;
    private ProgressDialog process;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
    public static final String TAG = "YOUR-TAG-NAME";
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MultiDex.install(this);
        setContentView(R.layout.activity_registor);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        process = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        name = (TextInputEditText) findViewById(R.id.NameUser);
        mail = (TextInputEditText) findViewById(R.id.mail);
        pass = (TextInputEditText) findViewById(R.id.password);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString();
                String mail1 = mail.getText().toString();
                String pass1 = pass.getText().toString();
                if (!TextUtils.isEmpty(name1) || !TextUtils.isEmpty(mail1) || !TextUtils.isEmpty(pass1)) {
                    process.setTitle("Registoring User");
                    process.setTitle("Please wait a second!");
                    process.setCanceledOnTouchOutside(false);

                    process.show();

                    registor(name1, mail1, pass1);

                }
            }
        });
    }

    private void registor(final String name1, final String email, final String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            user=mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fstore.collection("Users").document(user);
                            Map<String,Object> users=new HashMap<>();
                            users.put("FullName",name1);
                            users.put("MailId",email);
                            users.put("Password",password);
                            users.put("Image","No Image UpLoaded");

                            documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Registor.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                            });
                       /*     fstore.collection("users")
                                    .add(user)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error adding document", e);
                                        }
                                    });*/

                            //   database=FirebaseDatabase.getInstance().getReference().child(name1);
                            //     HashMap<String,String> hash=new HashMap<>();
                            //    hash.put("name",name1);

                            //      hash.put("image","default");

                            //      database.setValue(hash).addOnCompleteListener(new OnCompleteListener<Void>() {
                            //         @Override
                            //        public void onComplete(@NonNull Task<Void> task) {
                            //      if (task.isSuccessful()) {
                            process.dismiss();



                            // Intent intent = new Intent(Registor.this, loginPage.class);
                            //  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            //    startActivity(intent);
                            //    finish();


                            // FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            process.hide();
                            Toast.makeText(Registor.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });


    }

    private void checkemail() {
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener((new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(Registor.this, "Successfully Registered,verification mail sent!", Toast.LENGTH_LONG).show();
                        mAuth.signOut();
                        finish();


                        startActivity(new Intent(Registor.this, MainActivity.class));
                    } else {
                        Toast.makeText(Registor.this, "Fail to Registor,Please try again!", Toast.LENGTH_LONG).show();
                    }
                }
            }));





        }

    }
    @Override
    public void onBackPressed() {
        Intent start=new Intent(Registor.this,loginPage.class);
        startActivity(start);
        finish();
    }
}
