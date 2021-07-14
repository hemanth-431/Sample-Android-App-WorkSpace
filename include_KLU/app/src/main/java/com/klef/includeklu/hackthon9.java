package com.klef.includeklu;

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

public class hackthon9 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Technological advances for retail Outlets", "Clustering of Air objects based on trajectory", "Identification of Geo Location using smartphone in absence of internet and mobile network"};
    String mDescription[] = {"A software can be developed for Dispensing Unit of petrol pump, which would have a feature to convey the customer about the actual quantity of product delivered to the customer after fuelling. Similarly about the quality of product, if the product is off specification. This sensor should have a facility to measure the fuel quality and quantity and display it along with some quality parameters too.", "Smart and efficient Judiciary Interactive System: We often come across scenarios where stakeholders for a particular event (presentation, meeting, discussion, etc.) are at remote locations. In such cases, we observe many problems in flawless conduction of presentation or meeting, etc. We are looking for a software solution for smart and efficient judiciary interactive system. It should cover (1) facility for presentation to all the attendees (2) facility for discussion between Judiciary panel. Additional useful features are welcome.", "The smartphone will store geolocation in remote areas where no access to internet and mobile network is available and the location data with attributes will be synced to the server through SMS gateway or internet on availability of the same."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon9);
        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon9.MyAdapter adapter = new hackthon9.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon9.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon9.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon9.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon9.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon9.this, "GO..#INCLUDE", Toast.LENGTH_SHORT).show();
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
