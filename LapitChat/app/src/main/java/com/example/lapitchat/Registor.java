package com.example.lapitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registor extends AppCompatActivity {
private TextInputEditText name;
private TextInputEditText mail;
private TextInputEditText pass;
private Button button;
private Toolbar toolbar;
private DatabaseReference database;
private ProgressDialog process;
    private FirebaseAuth mAuth;
//Fire Base
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);

         process=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        name=(TextInputEditText)findViewById(R.id.toas);
        mail=(TextInputEditText)findViewById(R.id.mail);
        pass=(TextInputEditText)findViewById(R.id.password);
        button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(name.getText().toString()!=null &&mail.getText().toString()!=null && pass.getText().toString()!=null )
{ String name1=name.getText().toString();
                String mail1=mail.getText().toString();
                String pass1=pass.getText().toString();
                if(!TextUtils.isEmpty(name1) || !TextUtils.isEmpty(mail1) || !TextUtils.isEmpty(pass1)) {
                    process.setTitle("Registoring User");
                    process.setTitle("Please wait a second!");
                    process.setCanceledOnTouchOutside(false);

                    process.show();

                    registor(name1, mail1, pass1);

                }
            }}
        });
    }

    private void registor(final String name1, final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //dataBase
                         FirebaseUser currentuser=FirebaseAuth.getInstance().getCurrentUser();
                         String uid=currentuser.getUid();
database=FirebaseDatabase.getInstance().getReference().child(uid).child(name1);
                            HashMap<String,String> hash=new HashMap<>();
                            hash.put("name",name1);
                            hash.put("status","Hi There I am Using Lapy Chat");
                            hash.put("image","default");
                            hash.put("thumb image","default");
                            database.setValue(hash).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                        {
                                            process.dismiss();
                                            Intent intent=new Intent(Registor.this,MainActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            finish();
                                        }
                                }
                            });



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
}
