package com.example.splashliter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class extras extends AppCompatActivity {

    ImageView unfill,fill;
    String check="unfill";

 TextView like;
 int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
unfill=findViewById(R.id.unfill);
fill=findViewById(R.id.filled);
like=findViewById(R.id.likes);



        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("STRING_I_NEED")!= null)
        {
            Toast.makeText(extras.this,bundle.getString("STRING_I_NEED"),Toast.LENGTH_LONG).show();
        }
        }

        public void unfilled(View view){
        if(check.equals("unfill"))
        {count++;
            animateHeart(fill);
            fill.setVisibility(View.VISIBLE);
            unfill.setVisibility(View.GONE);
        }
        String s=Integer.toString(count);
        like.setText(s);
        Snackbar.make(view,"Like It",Snackbar.LENGTH_LONG).setAction("Action",null).show();
        check="fill";
        }

        public void filled(View view)
        {
            if (check.equals("fill"))
            {
                dislikeheart(unfill);
                fill.setVisibility(View.GONE);
                unfill.setVisibility(View.VISIBLE);
            }
if(count>0)
    count--;
String s1=Integer.toString(count);
like.setText(s1);
            Snackbar.make(view,"Dislike It",Snackbar.LENGTH_LONG).setAction("Action",null).show();
check="unfill";
        }

        private static Animation prepareAnimationn(Animation animation){
        animation.setRepeatCount(0);
        animation.setRepeatMode(Animation.REVERSE);
        return animation;
        }

        private static void dislikeheart(final ImageView view){
            ScaleAnimation scaleAnimation=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f, Animation.RELATIVE_TO_SELF,0.5f
            ,Animation.RELATIVE_TO_SELF,0.5f);
            prepareAnimationn(scaleAnimation);
            AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
            prepareAnimationn(alphaAnimation);
            AnimationSet animation=new AnimationSet(true);
            animation.addAnimation(alphaAnimation);
            animation.addAnimation(scaleAnimation);
            animation.setDuration(700);
            view.startAnimation(animation);


        }

        public static void animateHeart(final ImageView view)
        {
            ScaleAnimation scaleAnimation=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            prepareAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
            prepareAnimation(alphaAnimation);

            AnimationSet animation=new AnimationSet(true);
            animation.addAnimation(alphaAnimation);
            animation.addAnimation(scaleAnimation);
            animation.setDuration(500);
            view.startAnimation(animation);
        }

        public static Animation prepareAnimation(Animation animation)
        {
            animation.setRepeatCount(2);
            animation.setRepeatMode(Animation.REVERSE);
            return animation;
        }

    }


