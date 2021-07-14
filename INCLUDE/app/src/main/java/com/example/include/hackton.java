package com.example.include;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class hackton extends AppCompatActivity {
    CardView a, b, c, d, e, f, g, h, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackton);
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
                Intent i=new Intent(hackton.this,hackthon1.class);

                startActivity(i);
            }
        });
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon2.class);
        startActivity(i);
    }
});
c.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon3.class);
        startActivity(i);
    }
});
d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon4.class);
        startActivity(i);
    }
});
e.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon5.class);
        startActivity(i);
    }
});
f.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon6.class);
        startActivity(i);
    }
});
g.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon7.class);
        startActivity(i);
    }
});
h.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon8.class);
        startActivity(i);
    }
});
i.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(hackton.this,hackthon9.class);
        startActivity(i);
    }
});
    }
    @Override
    public void onBackPressed() {
        Intent start = new Intent(hackton.this, HomePage.class);
        startActivity(start);
        finish();
    }
}
