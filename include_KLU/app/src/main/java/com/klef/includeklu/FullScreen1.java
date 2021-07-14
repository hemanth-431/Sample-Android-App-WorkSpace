package com.klef.includeklu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreen1 extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen1);

        imageView=(ImageView)findViewById(R.id.image_view);

        Intent i=getIntent();
        int position=i.getExtras().getInt("id");
        imageadapter1 imageAdapter=new imageadapter1(this);
        imageView.setImageResource(imageAdapter.imagearray[position]);
    }
}
