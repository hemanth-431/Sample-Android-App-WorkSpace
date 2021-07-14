package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class test extends AppCompatActivity {
private EditText editText;
private EditText editText1;
private Button button;
private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
button=findViewById(R.id.button4);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        editText=findViewById(R.id.editText6);
        editText1=findViewById(R.id.editText2);
        String s=editText.getText().toString();
        String s1=editText1.getText().toString();
        Bundle b = getIntent().getExtras();
String s5=b.getString("Hemanth");
String s6=String.valueOf(s5);
        databaseReference= FirebaseDatabase.getInstance().getReference(s6);

        HashMap<String ,String> user=new HashMap<>();
        user.put("name",s);
        user.put("image",s1);
        databaseReference.setValue(user);//databaseReference.child("users").setValue(user);
        Intent intent=new Intent(test.this,circle.class);
        startActivity(intent);
    }
});


    }
}
