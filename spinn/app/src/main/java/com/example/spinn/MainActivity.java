package com.example.spinn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner mSpinner;
    TextView mOutputSpinnerTv;
    //options to be displayed in spinner
    String[] mOptions = {"Canada", "Pakistan", "Turkey", "US"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSpinner = findViewById(R.id.spinner);
        mOutputSpinnerTv = findViewById(R.id.outputSpinnerTv);

        //Creating the ArrayAdapter instance having the list of options
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mOptions);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setting the ArrayAdapter data on the Spinner
        mSpinner.setAdapter(aa);

        //spinner item click handler
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //METHOD 1: Get text from selected item's position & set it to TextView
                //mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());

                //METHOD 2: Get the position of item selected, & perform specific task
                if (position==0){
                    mOutputSpinnerTv.setText("Canada is selected...");
                }
                if (position==1){
                    mOutputSpinnerTv.setText("Pakistan is selected...");
                }
                if (position==2){
                    mOutputSpinnerTv.setText("Turkey is selected...");
                }
                if (position==3){
                    mOutputSpinnerTv.setText("US is selected...");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
