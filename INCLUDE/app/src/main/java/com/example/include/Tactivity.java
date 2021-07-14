package com.example.include;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Tactivity extends AppCompatActivity {

    CardView t1;
    CardView t2;
    CardView t3;
    CardView t4;
    CardView t5;
    CardView t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tactivity);

        t1=findViewById(R.id.b);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tactivity.this,t1.class));
            }
        });
        t2=findViewById(R.id.c);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tactivity.this,nt1.class));
            }
        });
        t3=findViewById(R.id.d);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tactivity.this,est.class));
            }
        });
        t4=findViewById(R.id.e);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tactivity.this,ppn.class));
            }
        });
        t5=findViewById(R.id.f);
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tactivity.this,pon.class));
            }
        });
        t6=findViewById(R.id.g);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tactivity.this,peo.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent start=new Intent(Tactivity.this,HomePage.class);
        startActivity(start);
        finish();
    }
}
