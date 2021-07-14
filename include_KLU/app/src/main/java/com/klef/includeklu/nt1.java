package com.klef.includeklu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class nt1 extends AppCompatActivity {
    CardView a1;
    CardView b1;
    CardView c1;
    CardView d1;
    CardView e1;
    CardView f1;
    CardView g1;
    CardView h1;
    CardView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt1);
        a1=findViewById(R.id.b);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,cry.class));
            }
        });
        b1=findViewById(R.id.c);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,de.class));
            }
        });
        c1=findViewById(R.id.d);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,hcs.class));
            }
        });
        d1=findViewById(R.id.e);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,mgt.class));
            }
        });
        e1=findViewById(R.id.f);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,snl.class));
            }
        });
        f1=findViewById(R.id.g);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,spbe.class));
            }
        });
        g1=findViewById(R.id.h);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,tq.class));
            }
        });
        h1=findViewById(R.id.i);
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,trhu.class));
            }
        });
        i1=findViewById(R.id.j);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(nt1.this,wdsc.class));
            }
        });
    }

}
