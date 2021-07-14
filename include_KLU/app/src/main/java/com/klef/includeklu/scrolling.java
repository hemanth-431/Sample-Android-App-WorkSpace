package com.klef.includeklu;

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
        models.add(new Model(R.drawable.chief1,"Chief Student Convenor",""));
        models.add(new Model(R.drawable.chief3,"Chief Student Advisor",""));
        models.add(new Model(R.drawable.chief,"Chief Student Coordinator",""));
        models.add(new Model(R.drawable.student,"Student CO-ORDINATOR",""));
        models.add(new Model(R.drawable.advisor,"Student Advisor",""));
        models.add(new Model(R.drawable.techn,"TECHNICAL",""));
        models.add(new Model(R.drawable.nontec,"NON-TECHNICAL",""));
        models.add(new Model(R.drawable.arts,"CREATIVE ARTS",""));
        models.add(new Model(R.drawable.broad,"BROAD CASTING",""));
        models.add(new Model(R.drawable.draft,"DRAFTING",""));
        models.add(new Model(R.drawable.logists,"LOGISTICS",""));
        models.add(new Model(R.drawable.proc,"PROTOCOL",""));
        models.add(new Model(R.drawable.pub,"PUBLIC RELATIONS",""));
        models.add(new Model(R.drawable.treas,"TREASURER",""));
        models.add(new Model(R.drawable.graphic,"GRAPHIC DESGINING",""));

        adapter=new cadapter(models,this);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color10),
                getResources().getColor(R.color.color11),
                getResources().getColor(R.color.color12),



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
