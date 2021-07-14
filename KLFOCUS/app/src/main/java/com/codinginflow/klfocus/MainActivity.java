package com.codinginflow.klfocus;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {

                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), home.class);
                    startActivity(intent);
                    finish();}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();



    }
}
