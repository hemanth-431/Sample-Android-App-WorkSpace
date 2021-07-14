package com.klef.includeklu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(aboutus.this,HomePage.class);
        startActivity(i);
    }
}
