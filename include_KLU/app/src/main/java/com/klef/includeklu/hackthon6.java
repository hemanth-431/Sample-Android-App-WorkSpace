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

public class hackthon6 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"AI Based Reservation System", "Tourism simplified through voice", "Virtual Tourist Guide"};
    String mDescription[] = {"Getting quicker and earliest booking in Indian Railways system is sometimes a challenge for passengers. The challenge is to devise an optimization using latest technologies which improves probability of getting ticket, improve booking time and customer experience remarkably. Expectations from solution are (1) Once passenger enters origin and destination, probable options and alternatives should be provided to him, within predefined/limited time frame. This should help passenger in getting confirm seat. (2) Additional functionality could be added to help passenger getting confirmed seats, improve booking time. (3) Data available in public domain/internet can be used by students to approach problem", "Alexa is Amazon’s cloud based voice service, that helps users interact with brands, data, and business logic through voice. Use Alexa to innovate, and build the next generation of interfaces for tourists in India. Your solution should help solve pain points of tourists coming to India like - voice forums to crowd source destination reviews, GPS based voice navigators to guide tourists at historical sites, SOS and emergency support solutions for local and international travelers, travel guides with entry prerequisites, government policies, visa needs, and recommendations on seasons to visit. The Alexabased solution should be intuitive to use also cater to the physically challenged travelers in India.", "Goa is a major tourist destination which pulls thousands of tourists every year. Goa is known for its beautiful beaches and hospitality. There are a number of monuments and landmarks depicting the cultural, history and development of Goa. Due to high inflow of domestic as well as international tourists, the manpower required to guide the tourists on these landmark is not sufficient and sometimes lack in the information that need to be given and highlighted to the tourist. Hence we propose the problem of developing a mobile application which renders information about the monument or landmark just by taking their live pictures as inputs. In other words, the application should allow the user to click a photograph and based on the picture it should display information about the monument/landmark. The application should also notify the user about such monuments/landmarks in the vicinity. The app should also allow the user to give their inputs about the object and also add to knowledge creation about the monuments/landmark. The app should also be able to keep statics about the number of users referring to the monument/landmark along with details of the users."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon6);
        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon6.MyAdapter adapter = new hackthon6.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon6.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon6.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon6.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon6.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon6.this, "GO..#INCLUDE", Toast.LENGTH_SHORT).show();
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
