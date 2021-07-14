package com.example.splashliter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class splash extends AppCompatActivity {
private Button button;
private TextView textView;

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this,"Option 1",Toast.LENGTH_LONG).show();
                return true;
            case R.id.option2:
                Toast.makeText(this,"Option 2",Toast.LENGTH_LONG).show();
                return true;
                default:
                    return super.onContextItemSelected(item);

        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example,menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView edit=findViewById(R.id.textView);
        registerForContextMenu(edit);




textView=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=textView.getText().toString();
                Date currentTime = Calendar.getInstance().getTime();
               int t=4;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());
                Toast.makeText(splash.this,currentDateandTime,Toast.LENGTH_LONG).show();
            //    Intent i = new Intent(splash.this, extras.class);

           //     i.putExtra("STRING_I_NEED", s);
            //    startActivity(i);

            }
        });
    }


}
