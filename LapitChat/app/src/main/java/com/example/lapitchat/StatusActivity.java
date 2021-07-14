package com.example.lapitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class StatusActivity extends AppCompatActivity {
private Toolbar toolbar;

private TextInputEditText textInputLayout;
private DatabaseReference databaseReference;
private Button button;
private FirebaseUser firebaseUser;
private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        String uid=firebaseUser.getUid();

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        toolbar=findViewById(R.id.status_bar_latest_event_content);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Action Status");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      String str=getIntent().getStringExtra("Start Value");
      textInputLayout=(TextInputEditText) findViewById(R.id.statusinput);
      button=findViewById(R.id.button6);
      textInputLayout.setText(str);


      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              progressDialog = new ProgressDialog(StatusActivity.this);
              progressDialog.setTitle("Save Changes");
              progressDialog.setMessage("Please Wait a Second");
              progressDialog.show();
              String status = textInputLayout.getText().toString();


              databaseReference.child("status").setValue(status).addOnCompleteListener(new OnCompleteListener<Void>() {
                  @Override
                  public void onComplete(@NonNull Task<Void> task) {
                      if (task.isSuccessful()) {
                          progressDialog.dismiss();


                      } else {
                          progressDialog.hide();
                          Toast.makeText(getApplicationContext(), "There Was a Problem", Toast.LENGTH_LONG).show();
                      }
                  }
              });
          }
      });

    }
}
