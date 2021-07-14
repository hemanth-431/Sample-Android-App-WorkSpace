package com.example.klhashinclude;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hackathon extends AppCompatActivity {
    CardView a, b, c, d, e, f, g, h, i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon);
        a = findViewById(R.id.g);
        b = findViewById(R.id.ab);
        c = findViewById(R.id.t);
        d = findViewById(R.id.n);
        e = findViewById(R.id.c);
        f = findViewById(R.id.r);
        g = findViewById(R.id.im);
        h = findViewById(R.id.ima);
        i=findViewById(R.id.imagrt);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon1.class);

                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon2.class);
                startActivity(i);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon3.class);
                startActivity(i);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon4.class);
                startActivity(i);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon5.class);
                startActivity(i);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon6.class);
                startActivity(i);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon7.class);
                startActivity(i);
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon8.class);
                startActivity(i);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(hackathon.this,hackathon9.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent start = new Intent(hackathon.this, HomePage.class);
        startActivity(start);
        finish();
    }
}
