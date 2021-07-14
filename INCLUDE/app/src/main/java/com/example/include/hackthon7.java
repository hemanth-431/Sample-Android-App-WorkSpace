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

public class hackthon7 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Providing a standardized measurement methodology for Internet access services (IAS) on Net Neutrality.", "How do you detect that an Internet Service Provider (ISP) is violating net neutrality?", "Develop a methodology/way to automatically infer throttling rate."};
    String mDescription[] = {"This methodology is targeted to maximising measurement accuracy and to enable the comparison of measurement results between different member states. The speed measurement is based on multiple HTTP connections and the document describes the calculation of the speed.", "You should develop an extensively validated, peer-reviewed approach for determining whether Internet service providers (ISPs) are giving different bandwidth to different applications (e.g., limiting the video resolution on certain streaming video apps by limiting the bandwidth available).", "Bandwidth throttling is the intentional slowing or speeding of an internet service by an Internet service provider (ISP). It is a reactive measure employed in communication networks to regulate network traffic and minimize bandwidth congestion."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon7);
        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon7.MyAdapter adapter = new hackthon7.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon7.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon7.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon7.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon7.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon7.this, "Youtube Description", Toast.LENGTH_SHORT).show();
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
