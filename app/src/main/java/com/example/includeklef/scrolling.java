package com.example.includeklef;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class scrolling extends AppCompatActivity {
    ViewPager viewPager;
    cadapter adapter;
    List<Model> models;
    Integer[] color=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);//------------------------------
        models=new ArrayList<>();
        models.add(new Model(R.drawable.saithrilok,"SAI THRILOK","ANDROID DEVELOPER"));
        models.add(new Model(R.drawable.hemanthpic,"Venkata Hemanth Bandla","ANDROID DEVELOPER"));
        models.add(new Model(R.drawable.shraddhakapoor,"SHRADDHA KAPOOR","ACTRESS"));
        models.add(new Model(R.drawable.praneeth,"PRANEETH","WEB DEVELOPER"));
        adapter=new cadapter(models,this);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.color1),

        };

        color=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionoffset, int positionoffsetpixels) {
                if (position<(adapter.getCount()-1)&&position<(color.length-1)){
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionoffset,color[position],color[position]));
                }
                else {
                    viewPager.setBackgroundColor(color[color.length-1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent start=new Intent(scrolling.this,HomePage.class);
        startActivity(start);
        finish();
    }
}
