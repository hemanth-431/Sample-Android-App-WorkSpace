package com.klef.includeklu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class peo extends AppCompatActivity {
    ViewFlipper v13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peo);
        int images[]= {R.drawable.k11, R.drawable.k22, R.drawable.k33, R.drawable.k44, R.drawable.k55};

        v13=findViewById(R.id.v1);
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
        v13.addView(imageView);
        v13.setFlipInterval(2000);
        v13.setAutoStart(true);
        v13.setInAnimation(this,android.R.anim.slide_in_left);
        v13.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
