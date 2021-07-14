package com.example.scrolllingimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.transition.Slide;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static com.example.scrolllingimages.R.id.content;
import static com.example.scrolllingimages.R.id.viepager;



public class MainActivity extends AppCompatActivity {
//private List<Slide> slideList=new ArrayList<>();
private ViewPager pager;

private SwipeAdapter pagerAdapter;
//private Timer timer;
//private int current=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=(ViewPager)findViewById(R.id.viepager);
        pagerAdapter=new SwipeAdapter(this);

        pager.setAdapter(pagerAdapter);

    }


}
