package com.klef.includeklu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class pon extends AppCompatActivity {
    ViewFlipper v12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pon);
        int images[]= {R.drawable.j1, R.drawable.j2, R.drawable.j3, R.drawable.j4};

        v12=findViewById(R.id.v1);
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
        v12.addView(imageView);
        v12.setFlipInterval(2000);
        v12.setAutoStart(true);
        v12.setInAnimation(this,android.R.anim.slide_in_left);
        v12.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
