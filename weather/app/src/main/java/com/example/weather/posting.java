package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class posting extends AppCompatActivity {
EditText a,b,c;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);
        a=findViewById(R.id.edittext);
        b=findViewById(R.id.edittext1);
        c=findViewById(R.id.edittext2);
        button=findViewById(R.id.butt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://mrubel.com/tuntuninews/api/newpostfromapp.php";
                StringRequest sq=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    protected Map<String,String> getParams(){
                        Map<String,String> parr=new HashMap<>();
parr.put("mytitle",a.getText().toString());
parr.put("mydate",b.getText().toString());
parr.put("mynews",c.getText().toString());
return parr;
                    }
                };
app.getInstance().addToRequestQueue(sq);
                Toast.makeText(getApplicationContext(),"sucess",Toast.LENGTH_LONG).show();
            }

        });
    }
}
