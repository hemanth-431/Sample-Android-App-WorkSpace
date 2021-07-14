package com.codinginflow.klfocus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class coordinatorregister extends AppCompatActivity {
    EditText txtname,txtteam,txtpassword,txtid;
    Button btncore;
    DatabaseReference reff;
    coordinator co;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorregister);

        txtname=(EditText)findViewById(R.id.etUserName);
        txtteam=(EditText)findViewById(R.id.etUserEmail);
        txtpassword=(EditText)findViewById(R.id.etUserPassword);
        txtid=(EditText)findViewById(R.id.etAge);
        btncore=(Button)findViewById(R.id.btnCoreRegister);

        co=new coordinator();
        reff= FirebaseDatabase.getInstance().getReference().child("coordinator");

        btncore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                co.setId(txtid.getText().toString().trim());
                co.setName(txtname.getText().toString().trim());
                co.setPassword(txtpassword.getText().toString().trim());
                co.setTeam(txtteam.getText().toString().trim());
                String id=txtid.getText().toString().trim();
                reff.child(id).setValue(co);
                Toast.makeText(coordinatorregister.this,"Co-Ordinator Added",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
