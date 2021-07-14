package com.example.agri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class main extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    RadioButton alluvial,lateric,red,sandy,black;
    RadioGroup soilselection1;
    ImageButton gn,jute,scane,to,coffee,rice,wheat,car,tom,cot,chil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent homeIntent=new Intent(main.this,splash.class);
                startActivity(homeIntent);
                finish();
            }


        },SPLASH_TIME_OUT);
        final RadioButton alluvial=findViewById(R.id.alluvial);
        final RadioButton lateric=findViewById(R.id.lateric);
        final RadioButton red=findViewById(R.id.red);
        final RadioButton sandy=findViewById(R.id.sandy);
        final RadioButton black=findViewById(R.id.black);
        final RadioGroup soilselection1=findViewById(R.id.soilselection1);
        gn=findViewById(R.id.Groundnut);
        jute=findViewById(R.id.jute);
        scane=findViewById(R.id.scane);
        to=findViewById(R.id.tobacco);
        coffee=findViewById(R.id.coffee);
        rice=findViewById(R.id.rice);
        wheat=findViewById(R.id.wheat);
        car=findViewById(R.id.carrot);
        tom=findViewById(R.id.tomato);
        cot=findViewById(R.id.cotton);
        chil=findViewById(R.id.chilli);
        gn.setVisibility(View.GONE);
        jute.setVisibility(View.GONE);
        scane.setVisibility(View.GONE);
        to.setVisibility(View.GONE);
        coffee.setVisibility(View.GONE);
        rice.setVisibility(View.GONE);
        wheat.setVisibility(View.GONE);
        car.setVisibility(View.GONE);
        tom.setVisibility(View.GONE);
        cot.setVisibility(View.GONE);
        chil.setVisibility(View.GONE);
        soilselection1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.alluvial){
                    gn.setVisibility(View.VISIBLE);
                    jute.setVisibility(View.VISIBLE);
                    scane.setVisibility(View.VISIBLE);
                    to.setVisibility(View.GONE);
                    coffee.setVisibility(View.GONE);
                    rice.setVisibility(View.GONE);
                    wheat.setVisibility(View.GONE);
                    car.setVisibility(View.GONE);
                    tom.setVisibility(View.GONE);
                    cot.setVisibility(View.GONE);
                    chil.setVisibility(View.GONE);
                }
                else if(checkedId==R.id.lateric){
                    gn.setVisibility(View.GONE);
                    jute.setVisibility(View.GONE);
                    scane.setVisibility(View.GONE);
                    to.setVisibility(View.VISIBLE);
                    coffee.setVisibility(View.VISIBLE);
                    rice.setVisibility(View.GONE);
                    wheat.setVisibility(View.GONE);
                    car.setVisibility(View.GONE);
                    tom.setVisibility(View.GONE);
                    cot.setVisibility(View.GONE);
                    chil.setVisibility(View.GONE);
                }
                else if(checkedId==R.id.red){
                    gn.setVisibility(View.GONE);
                    jute.setVisibility(View.GONE);
                    scane.setVisibility(View.GONE);
                    to.setVisibility(View.GONE);
                    coffee.setVisibility(View.GONE);
                    rice.setVisibility(View.VISIBLE);
                    wheat.setVisibility(View.VISIBLE);
                    car.setVisibility(View.GONE);
                    tom.setVisibility(View.GONE);
                    cot.setVisibility(View.GONE);
                    chil.setVisibility(View.GONE);                }
                else if(checkedId==R.id.sandy){
                    gn.setVisibility(View.GONE);
                    jute.setVisibility(View.GONE);
                    scane.setVisibility(View.GONE);
                    to.setVisibility(View.GONE);
                    coffee.setVisibility(View.GONE);
                    rice.setVisibility(View.GONE);
                    wheat.setVisibility(View.GONE);
                    car.setVisibility(View.VISIBLE);
                    tom.setVisibility(View.VISIBLE);
                    cot.setVisibility(View.GONE);
                    chil.setVisibility(View.GONE);
                }
                else if(checkedId==R.id.black){
                    gn.setVisibility(View.GONE);
                    jute.setVisibility(View.GONE);
                    scane.setVisibility(View.GONE);
                    to.setVisibility(View.GONE);
                    coffee.setVisibility(View.GONE);
                    rice.setVisibility(View.GONE);
                    wheat.setVisibility(View.GONE);
                    car.setVisibility(View.GONE);
                    tom.setVisibility(View.GONE);
                    cot.setVisibility(View.VISIBLE);
                    chil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    public void groundnut(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

}
