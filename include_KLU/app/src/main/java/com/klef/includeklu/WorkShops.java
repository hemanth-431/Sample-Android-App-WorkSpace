package com.klef.includeklu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class WorkShops extends AppCompatActivity {
CardView a,b,c,d,e,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_shops);
        a = findViewById(R.id.b);
        b = findViewById(R.id.c);
        c = findViewById(R.id.d);
        d = findViewById(R.id.e);
        e = findViewById(R.id.f);
        f = findViewById(R.id.g);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkShops.this, workshop1.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkShops.this, workshop2.class);
                startActivity(i);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WorkShops.this, workshop3.class);
                startActivity(i);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WorkShops.this,workshop4.class);
                startActivity(i);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WorkShops.this,workshop5.class);
                startActivity(i);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WorkShops.this,workshop6.class);
                startActivity(i);
            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent start=new Intent(WorkShops.this,HomePage.class);
        startActivity(start);
        finish();
    }
}
