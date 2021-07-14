package com.example.lapitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private Toolbar supportActionBar;
    private sectionpager section;
    private TabLayout  tabLayout;

private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        toolbar = findViewById(R.id.toolbsr);

        setSupportActionBar(toolbar);
getSupportActionBar().setTitle("LapitChat");
pager=findViewById(R.id.viepager);
        section = new sectionpager(getSupportFragmentManager());
        pager.setAdapter(section);
        tabLayout=findViewById(R.id.layoud);
        tabLayout.setupWithViewPager(pager);


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){

          sendToStart();
        }
    }

    private void sendToStart() {
        Intent start=new Intent(MainActivity.this,StartActivity.class);
        startActivity(start);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==(R.id.mainLogOut))
        { FirebaseAuth.getInstance().signOut();
        sendToStart();}

        if(item.getItemId()==R.id.MyAcco)
        {
            Intent intent=new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==(R.id.alluser)) {
            Intent intent = new Intent(MainActivity.this, UsersActivity.class);
            startActivity(intent);
        }
return true;
    }
}
