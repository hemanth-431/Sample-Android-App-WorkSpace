package com.example.agri;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name;
    private TextInputEditText mail;
    private TextInputEditText crop;
    private TextInputEditText pass;
    private Button button;
    private Button button1;
    private Toolbar toolbar;
    private DatabaseReference database;
    private ProgressDialog process;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
    private FirebaseDatabase rootnode;
    public static final String TAG = "YOUR-TAG-NAME";
    String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        process = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();
        crop=findViewById(R.id.crop);
        name = (TextInputEditText) findViewById(R.id.NameUser);
        mail = (TextInputEditText) findViewById(R.id.mail);
        button1=findViewById(R.id.button4);
        pass = (TextInputEditText) findViewById(R.id.password);
        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final    String
                        cr=crop.getText().toString().trim();
                String s = name.getText().toString().trim();
                if (s != null && cr!=null) {
                    rootnode = FirebaseDatabase.getInstance();
                    database = rootnode.getReference("users").child(cr).child("use");
                    database.setValue(cr);
                    database = rootnode.getReference("users").child(cr).child("cost");
                    database.setValue(s);
                }
            }

        });
button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        database=rootnode.getReference().child("users");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final    String
                        cr=crop.getText().toString().trim();
                String name=dataSnapshot.child(cr).getValue().toString();
                if(name!=null)
                mail.setText(name);

               Intent i=new Intent(MainActivity.this,home.class);
              startActivity(i);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
});

    }





    }
