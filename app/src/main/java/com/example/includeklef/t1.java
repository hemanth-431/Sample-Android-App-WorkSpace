package com.example.includeklef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class t1 extends AppCompatActivity {
    CardView a1;
    CardView b1;
    CardView c1;
    CardView d1;
    CardView e1;
    CardView f1;
    CardView g1;
    CardView h1;
    CardView i1;
    CardView j1;
    CardView k1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1);
        a1=findViewById(R.id.b);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,ic.class));
            }
        });
        b1=findViewById(R.id.c);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,cco.class));
            }
        });
        c1=findViewById(R.id.d);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,hs.class));
            }
        });
        d1=findViewById(R.id.e);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,sd.class));
            }
        });
        e1=findViewById(R.id.f);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,fh.class));
            }
        });
        f1=findViewById(R.id.g);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,vc.class));
            }
        });
        g1=findViewById(R.id.h);
        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,wka.class));
            }
        });
        h1=findViewById(R.id.i);
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,hs2.class));
            }
        });
        i1=findViewById(R.id.j);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,cen.class));
            }
        });
        j1=findViewById(R.id.k);
        j1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,mht.class));
            }
        });
        k1=findViewById(R.id.l);
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(t1.this,flp.class));
            }
        });
    }
}
