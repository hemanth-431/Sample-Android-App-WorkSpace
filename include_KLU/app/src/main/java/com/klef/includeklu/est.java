package com.klef.includeklu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class est extends AppCompatActivity {
    ViewFlipper v14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_est);
        int images[]= {R.drawable.a11, R.drawable.a22, R.drawable.a33, R.drawable.a44};

        v14=findViewById(R.id.v1);
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
        v14.addView(imageView);
        v14.setFlipInterval(2000);
        v14.setAutoStart(true);
        v14.setInAnimation(this,android.R.anim.slide_in_left);
        v14.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
