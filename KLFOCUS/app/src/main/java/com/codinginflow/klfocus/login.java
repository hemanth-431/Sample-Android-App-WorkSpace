package com.codinginflow.klfocus;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Spinner spinner;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        spinner=(Spinner)findViewById(R.id.login);
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
    }
    public void onClickLogin(View view)
    {

        final String strspinner=String.valueOf(spinner.getSelectedItem());
        final String strid=Name.getText().toString();
        final String strpass=Password.getText().toString();







        //ref = FirebaseDatabase.getInstance().getReference().child("core");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference userNameRef = rootRef.child(strspinner).child(strid);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()) {
                    Toast.makeText(getApplicationContext(),"No user found",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User exists",Toast.LENGTH_SHORT).show();
                    userNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            core userProfile = dataSnapshot.getValue(core.class);

                            if(strpass.equals(userProfile.getPassword()))
                            {
                                Toast.makeText(getApplicationContext(),"Password checked",Toast.LENGTH_SHORT).show();
                                if(strspinner.equals("admin")) {
                                    Intent intentOnSendMessage = new Intent(getApplicationContext(), admin.class);
                                    startActivity(intentOnSendMessage);
                                    Toast.makeText(getApplicationContext(),"admin module",Toast.LENGTH_SHORT).show();

                                }
                                else if(strspinner.equals("core"))
                                {
                                    Toast.makeText(getApplicationContext(),"core module",Toast.LENGTH_SHORT).show();
                                }
                                else if(strspinner.equals("coordinator"))
                                {
                                    Toast.makeText(getApplicationContext(),"coordinator module",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    //Intent intentOnSendMessage=new Intent(getApplicationContext(),admin.class);
                    //startActivity(intentOnSendMessage);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        userNameRef.addListenerForSingleValueEvent(eventListener);





















    }
}
