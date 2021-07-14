package com.example.includeklef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
    ImageButton button;
    CardView a,b,c,d;
    ViewFlipper v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        button=findViewById(R.id.a);
        a=findViewById(R.id.g);
        b=findViewById(R.id.ab);
        c=findViewById(R.id.t);
        d=findViewById(R.id.c);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent start=new Intent(HomePage.this,MainActivity.class);
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
        int images[]= {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4};

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
