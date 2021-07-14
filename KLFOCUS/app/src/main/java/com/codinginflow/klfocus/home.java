package com.codinginflow.klfocus;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

public class home extends AppCompatActivity {

    CardView cardView1,cardView2,cardView3,cardView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardView1=(CardView)findViewById(R.id.web);
        cardView2=(CardView)findViewById(R.id.log);
        cardView3=(CardView)findViewById(R.id.add);
        cardView4=(CardView)findViewById(R.id.links);


        cardView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentOnSendMessage=new Intent(getApplicationContext(),website.class);
                startActivity(intentOnSendMessage);
            }
        });


        cardView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentOnSendMessage=new Intent(getApplicationContext(),login.class);
                startActivity(intentOnSendMessage);
            }
        });



        cardView3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentOnSendMessage=new Intent(getApplicationContext(),admin.class);
                startActivity(intentOnSendMessage);
            }
        });





    }
}
