package com.example.mail;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class circle extends AppCompatActivity {
    private CircleImageView circleImageView;
    private Button button;
    private FirebaseUser firebaseUser;
    private Toolbar toolbar;
   public EditText editText9;
    private DatabaseReference database;
    private ProgressDialog process;
    private FirebaseAuth mAuth;
    private static final int GALARY_PIC = 1;
    private DatabaseReference databaseReference;
    //Fire Base
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        editText9=findViewById(R.id.editText);
        circleImageView = findViewById(R.id.circleImageView);

//FirebaseUser f=FirebaseAuth.getInstance().getCurrentUser();
//String current=f.getUid();
        button=findViewById(R.id.button3);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String s=editText9.getText().toString();
        databaseReference=FirebaseDatabase.getInstance().getReference(s);

            HashMap<String ,String> user=new HashMap<>();
            user.put("name","he");
            user.put("image","she");
            databaseReference.child("user").setValue(user);
        Intent intent=new Intent(circle.this,test.class);
        intent.putExtra("Hemanth",s);

    startActivity(intent);}

});





    }


        }

