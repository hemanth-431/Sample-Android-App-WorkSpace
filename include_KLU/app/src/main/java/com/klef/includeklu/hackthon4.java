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

public class hackthon4 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"AGV Path Calculator", "Last Mile Delivery", "Intelligent Scanning System"};
    String mDescription[] = {"High-speed calculation software that can consider the available path of a vehicle with trolley. Simulate the tracking and check if the vehicle can pass. And, when the angle at the arrival point is instructed, it will consider moving (including back movement) to reach at that angle. In real world, working like Tractor-trolley vehicle", "These days we are pretty habituated of home- delivery system through e-commerce platform, however there is a big dependency on delivery boys and vehicles for timely delivery of the items. We could potentially use Drones for last mile delivery of items. While current prevalent addressing mechanism such as lat/long and postcode are good enough for humans, these won’t work for drone delivery as all houses in a multi-storey building will have the same lat/long or post-code. Design a solution which can help drones to identify each address / flat as a separate unit and deliver the item accordingly.", "We are looking for solution of automatic checking of parcels in parcel offices (both booked by Railway and leaseholders). We are expecting the solution to be (1) Automatic (without human intervention) (2) quick (3) cost effective The solutions are needed to be (1) It should automatically detect and check parcels in parcel office (booked by both Railway and leaseholders). Parcels' count and details should be updated to centralised server. (2) Software component should show details of parcels i.e.,Parcel number, source and destination address in parcel office to officials and operators. (3) If parcel is dispatched from parcel office, it should be removed from In Office Parcels and if parcel is received at Parcel office, it should be added to In Office Parcels."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon4);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon4.MyAdapter adapter = new hackthon4.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon4.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon4.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon4.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon4.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon4.this, "GO..#INCLUDE", Toast.LENGTH_SHORT).show();
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
