package com.example.klhashinclude;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class eventsG extends AppCompatActivity {
    CardView a,b,c,d,e,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_g);
        a=findViewById(R.id.b);
        b=findViewById(R.id.c);
        c=findViewById(R.id.d);
        d=findViewById(R.id.e);
        e=findViewById(R.id.f);
        f=findViewById(R.id.g);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eventsG.this,gallery.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eventsG.this,gallery1.class);
                startActivity(i);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eventsG.this,gallery2.class);
                startActivity(i);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eventsG.this,gallery3.class);
                startActivity(i);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eventsG.this,gallery4.class);
                startActivity(i);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(eventsG.this,gallery5.class);
                startActivity(i);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(eventsG.this,HomePage.class);
        startActivity(i);
    }
}
