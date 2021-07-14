package com.codinginflow.klfocus;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class takeattendance extends AppCompatActivity {
    Button btn_scan,btn_post;
    EditText editdate,editid;
    DatabaseReference reff;
    attendance attendancee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeattendance);
        editdate=(EditText)findViewById(R.id.date);
        editid=(EditText)findViewById(R.id.postid);

        attendancee=new attendance();
        reff= FirebaseDatabase.getInstance().getReference().child("attendance");


        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yy");
        final String datetime=simpleDateFormat.format(calendar.getTime());

        btn_post = (Button) findViewById(R.id.postattendance);
        btn_scan = (Button) findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator scanIntegrator = new IntentIntegrator(takeattendance.this);
                scanIntegrator.initiateScan();
                editdate.setText(datetime);
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendancee.setId(editid.getText().toString().trim());
                String idnum=editid.getText().toString().trim();
                String date=editdate.getText().toString().trim();
                reff.child(date).child(idnum).setValue(attendancee);

            }
        });

    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent in ) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, in);

        if (scanningResult != null) {

            String contents = in.getStringExtra( "SCAN_RESULT" );
            String format = in.getStringExtra( "SCAN_RESULT_FORMAT" ) ;
            Toast.makeText(takeattendance.this, "Content-" + contents + " Format-" + format, Toast.LENGTH_LONG).show();
            editid.setText(contents);
        }


    }
}
