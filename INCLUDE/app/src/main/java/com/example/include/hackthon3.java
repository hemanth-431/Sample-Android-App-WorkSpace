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

public class hackthon3 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Voice prescription", "Health Records Accessing", "Device to measure steroids in Milk/Meat Products", "Virtual Reality for Yoga-Asana/ Meditation"};
    String mDescription[] = {"Design an app to write formatted prescriptions based on dictation from doctor. Refer attachment for more detail. The app should provide facility to sign the prescription and also send to the patient directly on his phone and email id.", "EHR generally contains highly-sensitive and critical data related to patients, which is frequently shared among clinicians, radiologists, healthcare providers, pharmacists, and researchers, for effective diagnosis and treatment. Hence, may use block chain technology for accessing and managing the privacy and security of patient data and history in clinical practices.", "\"In order to increase the productivity of milk and meat products, the animals/birds are inoculated with steroid which boost the production of milk and development of meat. The same steroid enter the food chain and unknowingly are consumed by humans. It is understood that the effects of steroids on animals is also observed in humans. The steroids when consumed by humans can cause severe damage to the body. The problem statement is to develop a device that would help check the amount of steroids in milk and meat products. Design a tool to insert the steroid and measure the amount of steroid added. This should inform the right amount of steroid that can be added depending on the weight of the animal/quantity of milk to ensure that wrong amount is not added.\"", "Yoga & Meditation – An essential daily Routine Need Motivation and proper environment.Create a virtual reality Mascot / Hologram device that can be made which features different modes of Yoga Asanas and a peaceful environment around. This device will help in better concentration as it will provide soothing environment. VR software requirement: The VR Experience should be able to provide a virtual tour of interiors of yoga hall and the structure of yoga asana demonstration. The participant should be able to do the same body Asana by looking at the Mascot/Hologram.The Virtual Reality Experience should be smooth."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon3);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon3.MyAdapter adapter = new hackthon3.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon3.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon3.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon3.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon3.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon3.this, "Youtube Description", Toast.LENGTH_SHORT).show();
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
