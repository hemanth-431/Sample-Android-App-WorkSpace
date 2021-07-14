package com.example.second;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int n1,n2;
int result;
String n3,n4;
EditText number1;
EditText number2;
EditText Result;
Button Add;
Button sub;
Button mul;
Button div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1=findViewById(R.id.editText2);
        number2=findViewById((R.id.editText));
        Result=findViewById(R.id.editText3);
        //n3=number1.getText().toString();
//n4=number2.getText().toString();

Add=findViewById(R.id.button4);
sub=findViewById(R.id.button);
mul=findViewById(R.id.button2);
div=findViewById(R.id.button3);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(number1.getText().toString());
                n2= Integer.parseInt(number2.getText().toString());
                result=n1+n2;

                Result.setText(String.valueOf(result));

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(number1.getText().toString());
                n2= Integer.parseInt(number2.getText().toString());
                result=n1-n2;

                Result.setText(String.valueOf(result));

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(number1.getText().toString());
                n2= Integer.parseInt(number2.getText().toString());
                result=n1*n2;

                Result.setText(String.valueOf(result));

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(number1.getText().toString());
                n2= Integer.parseInt(number2.getText().toString());
                result=n1/n2;

                Result.setText(String.valueOf(result));

            }
        });
    }
}
