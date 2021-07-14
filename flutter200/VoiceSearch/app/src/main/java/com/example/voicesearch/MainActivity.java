package com.example.voicesearch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 10000;
    TextView mtext;
ImageView mvoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtext=findViewById(R.id.textTv);
        mvoice=findViewById(R.id.voiceBtn);

        mvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

    }
    public void speak(){
        Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT,"How is your mood today?");
        try{
                 startActivityForResult(i,REQUEST_CODE_SPEECH_INPUT);
        }catch (Exception e){
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case REQUEST_CODE_SPEECH_INPUT:{

                if(resultCode == RESULT_OK && null!=data)
                {
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                result.get(0).split(" ");
                int c=0;
                   if(result.get(0).contains("sad"))
                   {
                       c++;
                       Intent i=new Intent(MainActivity.this,List1.class);
                       Toast.makeText(MainActivity.this,result.get(0),Toast.LENGTH_LONG).show();
                       startActivity(i);
                   }
                    if(result.get(0).contains("happy"))
                    {
                        c++;
                        Intent i=new Intent(MainActivity.this,List2.class);
                        Toast.makeText(MainActivity.this,result.get(0),Toast.LENGTH_LONG).show();
                        startActivity(i);
                    }
                    if(c==0)
                    {
                        Toast.makeText(MainActivity.this,"Sorry i can't Understand",Toast.LENGTH_LONG).show();
                    }



                }
                break;
            }
        }
    }
}
