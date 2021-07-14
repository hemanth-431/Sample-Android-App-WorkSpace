package com.klef.includeklu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class ppn extends AppCompatActivity {
    ViewFlipper v11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppn);
        int images[]= {R.drawable.i11, R.drawable.i22, R.drawable.i33, R.drawable.i44};

        v11=findViewById(R.id.v1);
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
        v11.addView(imageView);
        v11.setFlipInterval(2000);
        v11.setAutoStart(true);
        v11.setInAnimation(this,android.R.anim.slide_in_left);
        v11.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
