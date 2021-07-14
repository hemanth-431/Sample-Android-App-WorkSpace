package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class post extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
button=findViewById(R.id.button1);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

Intent i=new Intent(post.this,posting.class);
startActivity(i);
    }
});

    }
}
