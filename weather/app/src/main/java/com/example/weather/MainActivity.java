package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView  t1,t2,t3,t4;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        button=findViewById(R.id.button);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        findweather();
    }

    private void findweather() {
        String url="http://localhost:8000/Shops/?format=json";
      //  String url="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
        JsonObjectRequest jor=new JsonObjectRequest(JsonRequest.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Calendar calendar=Calendar.getInstance();
                    SimpleDateFormat sdf=new SimpleDateFormat("EEEE-MM-dd");
                    String format=sdf.format(calendar.getTime());
                    t4.setText(format);
                    String c=response.getString("name");
                    t1.setText(c);
                    JSONArray array=response.getJSONArray("fields");
                  /*  JSONObject main=response.getJSONObject("main");
                    JSONArray array=response.getJSONArray("weather");
                    JSONObject object=array.getJSONObject(0);
                    String temp=String.valueOf(main.getDouble("temp"));
String desc=object.getString("description");
String City=response.getString("name");*/
String a=response.getString("product_brand");
String b=response.getString("category");

//t1.setText(temp);
t2.setText(a);
t3.setText(b);

                   // t1.setText(c);
                 //   double tempint=Double.parseDouble(temp);
                //    double centi=(tempint-32)/1.8000;
               //     centi=Math.round(centi);
               //     int i=(int)centi;
              //      t1.setText(String.valueOf(i));
                }
                catch (Exception e)
                {

                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue que= Volley.newRequestQueue(this);
        que.add(jor);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,post.class);
                startActivity(i);
            }
        });
    }

}
