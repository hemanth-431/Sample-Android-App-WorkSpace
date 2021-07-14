package com.klef.includeklu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreen2 extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen2);

        imageView=(ImageView)findViewById(R.id.image_view);

        Intent i=getIntent();
        int position=i.getExtras().getInt("id");
        imageadapter2 imageAdapter=new imageadapter2(this);
        imageView.setImageResource(imageAdapter.imagearray[position]);
    }
}
