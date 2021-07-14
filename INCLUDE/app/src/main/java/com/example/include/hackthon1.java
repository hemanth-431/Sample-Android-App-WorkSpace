package com.example.include;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class hackthon1 extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Automatic Assessment of Pavement condition based on road photographs", "Process Modeling", "Extraction of crop cycle parameters from multi-temporal data", "Drudgery reduction of women in rural areas", "Manual operations of Microla and Biola Bottle filling, capping, labelling and packing, leading to spoilage and wastage of manpower"};
    String mDescription[] = {"Works constructed under the Government scheme are to be maintained by the contractor as per the government guidelines. Pavement Condition Index is required to be performed to identify the road condition and further to take the maintenance or upgradation of the work. Through some governmental schemes, NRIDA has collected a vast collection of pictures of roads. These pictures are collected while doing inspection of roads. An AI assisted module would be able to automatically assess the picture and identify common issues such as shoulder clearance, potholes, road furniture etc. Requirement is of a solution where there should be a provision to capture the chainage wise pavement condition index. Use of open source software and existing neural network is encouraged. Train a machine learning model, computer vision etc. which is able to identify common issues with pavement based on photograph(s) per road alone.", "Develop a Asset Performance Monitoring (APM) platform based on ML algorithms to calculate the real-time reliability and efficiency of the process plant equipments such as heat exchangers, turbines, pumps, motors, compressors, expanders and reacting columns with respect to the design data. Suggestions to optimize the operational parameters of the different equipment’s for getting the maximum possible efficiency in dynamic operational scenario. For ex- Developing the platform that enables the asset performance monitoring via calculation of the heat transfer efficiency of heat exchangers, optimized operational parameters and reliability for the rotating equipments such as turbines, compressors etc.", "For the taken set of multispectral multi-temporal data with timestamp of one year or more, develop and implement an algorithm for extracting crop cycle parameters. Participants need to develop a high-performance algorithm to analyse multi-temporal data at each pixel to extracting parameters such as date of sowing, date of harvesting and number of harvests based on temporal profile.", "Rural women play a significant role inside the houses as well as on farms along with animal husbandry work. This triple burden has made the life of rural women especially in hilly areas miserable & full of drudgery. The main activities which significantly increase their drudgery level in hilly rural areas are - Farm: Farm activities including harvesting, Weeding & hoeing, etc. Home: Cooking & collection of fuel and fodder. Animal husbandry and allied activities. We require some technological interventions in order to reduce drudgery of women.", "Manual operations of Microla and Biola Bottle filling, capping, labeling and packing, leading to spoilage and wastage of manpower. Possible solution: Automation of bottling of Microla and Biola with development of assembly line for filling of bottle, capping, labeling and final packing."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon1);
        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon1.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon1.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon1.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon1.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon1.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
}
