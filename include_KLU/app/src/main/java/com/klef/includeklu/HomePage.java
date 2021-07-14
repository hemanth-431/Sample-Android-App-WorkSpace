package com.klef.includeklu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
ImageButton button;
CardView a,b,c,d,e,f;
    ViewFlipper v1;
    TextView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

a=findViewById(R.id.g);
b=findViewById(R.id.ab);
c=findViewById(R.id.t);
d=findViewById(R.id.c);
e=findViewById(R.id.n);
f=findViewById(R.id.r);
logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent start=new Intent(HomePage.this,loginPage.class);
                startActivity(start);
                finish();
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start=new Intent(HomePage.this,eventsG.class);
                startActivity(start);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start=new Intent(HomePage.this,scrolling.class);
                startActivity(start);
                finish();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start=new Intent(HomePage.this,hackton.class);
                startActivity(start);
                finish();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start=new Intent(HomePage.this,Tactivity.class);
                startActivity(start);
                finish();
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start=new Intent(HomePage.this,WorkShops.class);
                startActivity(start);
                finish();
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start=new Intent(HomePage.this,aboutus.class);
                startActivity(start);
                finish();
            }
        });
        int images[]= {R.drawable.sp1,R.drawable.webcomp};

        v1=findViewById(R.id.v1);
       /*for (int i=0; i<images.length; i++){
            flipperImages(images[i]);
        } */
        for(int image:images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView=new ImageView(this );
        imageView.setBackgroundResource(image);
        v1.addView(imageView);
        v1.setFlipInterval(2000);
        v1.setAutoStart(true);
        v1.setInAnimation(this,android.R.anim.slide_in_left);
        v1.setOutAnimation(this,android.R.anim.slide_out_right);

    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}
