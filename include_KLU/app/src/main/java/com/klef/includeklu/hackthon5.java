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

public class hackthon5 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Cyber Crime Prevention", "Clustering of Air objects based on trajectory", "Tracking and Control of inmate inside the Jail", "How to prevent cheating in exams?"};
    String mDescription[] = {"Cyber bullying involves posting and sharing wrong, private, negative, harmful information about victim. In today's digital world we see many such instances where a particular person is targeted. We are looking for a software solution to curb such bullying/harassment in cyberspace. Such solution is expected to (1) work on social media such as twitter, facebook,etc. and on SMS, etc. (2) should alarm the authorities (3) facility to report such incidents to authorities. Additional useful features are welcome", "The position of an object in the air can be indicated by latitude, longitude and altitude for a given time. A trajectory is a stream of such quadruples (time, latitude, longitude and altitude). Given a large set of such trajectories, without any other information, problem is to cluster them into meaningful objects such as Helicopter, Fighter/civilian Aircraft, UAV, Cruise Missile, dropped bomb, etc. An optimal scalable solution is desired using open source tools. Design a system to estimate the location of flying object based on its trajectory, provide guidance to missiles to shoot them depending on their location when missile will meet the object on its trajectory.", "prisoners are segregated in different wards as per Jail Manual. But it is the tendencies of a few bad elements to leave the barracks on the pretext of availing Medical Services,Canteen Services, telephone Services etc and going to some others barracks to receive or to distribute or to prepare a prohibited article. prison Department wants to put some Bio-ID based gates turnstiles which can identify the prisoner ,whether he reached to the designated place of service for which he was permitted . The Bio-Id of inmates is available in web based application with Demographic details of inmates. Technological Solutions on this issue may be developed through Living Lab.", "Develop an integrated system which can help in preventing cheating in examination. Use CCTV recordings to automatically detect cheating in the exam hall and mark them for review."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon5);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon5.MyAdapter adapter = new hackthon5.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon5.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon5.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon5.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon5.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon5.this, "GO..#INCLUDE", Toast.LENGTH_SHORT).show();
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
