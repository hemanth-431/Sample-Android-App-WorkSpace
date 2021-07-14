package com.example.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText to;
    EditText sub;
    EditText mess;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        to = findViewById(R.id.editText3);
        sub = findViewById(R.id.editText4);
        mess = findViewById(R.id.editText5);
        Button button = findViewById(R.id.button);
        Button button1=findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,circle.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sent();
            }
        });


    }
        public void sent()
        {
            String s=to.getText().toString();
            String s1[]=s.split(",");
            String sub1=sub.getText().toString();
            String mess1=mess.getText().toString();
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,s1);
            intent.putExtra(Intent.EXTRA_SUBJECT,sub1);
            intent.putExtra(Intent.EXTRA_TEXT,mess1);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"choose an email Clint"));
        }
    }

