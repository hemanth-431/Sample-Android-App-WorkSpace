package com.example.splashliter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.splashliter.Fragment.HomeFragment;
import com.example.splashliter.Fragment.NotificationFragment;
import com.example.splashliter.Fragment.ProfileFragment;
import com.example.splashliter.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment select=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView=findViewById(R.id.bottom_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelect);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelect=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId())
            {
                case R.id.nav_home:
                    select=new HomeFragment();
                    break;
                case R.id.nav_search:
                    select=new SearchFragment();
                    break;

                case R.id.nav_add:
                    select=null;
                    startActivity(new Intent(Main.this,postActivity.class));
                    break;
                case R.id.nav_heart:
                    select=new NotificationFragment();
                    break;
                case R.id.nav_profile:
                    SharedPreferences.Editor editor=getSharedPreferences("PREFS",MODE_PRIVATE).edit();
                  //  editor.putString("profileid",FirebaseAuth.getInstance().getCurrentUser().getUid());
                    editor.putString("profileid","hemanth");
                    editor.apply();
                    select=new ProfileFragment();
                    break;


            }
            if (select!=null)
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,select).commit();
            }
            return false;
        }
    };
}
