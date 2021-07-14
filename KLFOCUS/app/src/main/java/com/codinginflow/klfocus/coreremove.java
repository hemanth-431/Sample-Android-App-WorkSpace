package com.codinginflow.klfocus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class coreremove extends AppCompatActivity {
    EditText txtremcore;
    Button btnremcore;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coreremove);
        txtremcore=(EditText)findViewById(R.id.adminremcore);
        btnremcore=(Button)findViewById(R.id.btnremcore);

        reff= FirebaseDatabase.getInstance().getReference().child("core");

        btnremcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=txtremcore.getText().toString().trim();
                reff.child(id).removeValue()
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // There has been an error fetching the config
                                //Log.w(TAG, "Error fetching config", e);
                                //applyRetrievedLengthLimit();
                                Toast.makeText(coreremove.this,"Failed",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
