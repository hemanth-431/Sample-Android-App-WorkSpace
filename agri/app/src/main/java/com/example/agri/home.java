package com.example.agri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {
private DatabaseReference database;
private TextInputEditText t1;
ListView my;
    ArrayList<String> array = new ArrayList<>();

private Spinner spinner;
DatabaseReference databaseReference;
    private FirebaseDatabase rootnode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> myad = new ArrayAdapter<>(home.this, android.R.layout.simple_list_item_1, array);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        DatabaseReference usersdRef = databaseReference.child("users");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String name = ds.getKey().toString();
                 String name1=ds.child("name").child("use").getValue(String.class);

                if(name!=null)
                    array.add(name);

                }
                ArrayAdapter<String> adapter = new ArrayAdapter(home.this, android.R.layout.simple_list_item_1, array);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        usersdRef.addListenerForSingleValueEvent(eventListener);


    }


    }








     /*   database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("use").getValue().toString();
                t1.setText(name);

                //-----------------------------
                ArrayList<String> cate=new ArrayList<>();
                cate.add(0,"Choose");
                cate.add("hi");
                cate.add("Hello");
                cate.add("pop");


                 ArrayAdapter<String> adapter;
                adapter=new ArrayAdapter(home.this,android.R.layout.simple_spinner_dropdown_item,cate);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(parent.getItemAtPosition(position).equals("Choose category"))
                        {

                        }
                        else {
                            Toast.makeText(home.this,"Yes",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
//-----------------------------------
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/