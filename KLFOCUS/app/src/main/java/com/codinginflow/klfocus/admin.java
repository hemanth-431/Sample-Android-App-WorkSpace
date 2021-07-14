package com.codinginflow.klfocus;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        final Button addcore = findViewById(R.id.adminaddcore);
        final Button remcore = findViewById(R.id.adminremovecore);
        final Button addco = findViewById(R.id.adminaddcoordinator);
        final Button remco = findViewById(R.id.adminremovecoordinator);
        final Button viewatt = findViewById(R.id.adminviewattendence);
        final Button viewcore = findViewById(R.id.adminviewcore);
        final Button viewco = findViewById(R.id.adminviewcoordinator);
        final Button takeatt = findViewById(R.id.admintakeattendence);

        addcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,coreregister.class));
            }
        });

        addco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,coordinatorregister.class));
            }
        });

        remcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,coreremove.class));
            }
        });

        takeatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this,takeattendance.class));
            }
        });

    }
}
