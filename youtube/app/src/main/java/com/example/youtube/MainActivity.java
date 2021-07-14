package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name,email;
    String number;
    EditText user;
    EditText sampleInput;
    EditText number1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText) findViewById(R.id.editText);

        sampleInput=(EditText) findViewById(R.id.editText2);
        number1=(EditText) findViewById(R.id.editText3);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=user.getText().toString()+" "+sampleInput.getText().toString()+" "+number1.getText().toString();


                show(name);
            }
        });

    }
        private void show(String text)
        {
            Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
        }
    }

