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

public class hackthon8 extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Design a solution to get toll paid using Mobile wallet methods", "Develop an Offline payments strategy via mobile wallets using SMS", "A prototype/Model that reduces phishing attacks in mobile wallets"};
    String mDescription[] = {"1-2 km before the toll plaza, a notification should be received on the mobile phone of the approaching user with Toll Name and amount of applicable Toll Fee. Payment can be facilitated through mobile wallets and credit cards payment integration. An electronic receipt be generated, with barcode/QR code which can be shown at the Toll Booth. A list for all the toll plaza and respective services to be made available in the app", "Now a day’s eWallet is very handy application. It has some advantages and disadvantages. When a customer is purchasing some items and about to pay the amount but at the same time lost the eWallet connectivity or eWallet is not responding. Then customer has to wait until the server responds or needs to return the items to the merchant. existing mobile phone features like Bluetooth or Messaging (SMS) can do digital money transactions in offline mode (for the time being) at customer end", "Now a day’s eWallet is very handy application. It has some advantages and disadvantages. When a customer is purchasing some items and about to pay the amount but at the same time lost the eWallet connectivity or eWallet is not responding. Then customer has to wait until the server responds or needs to return the items to the merchant. existing mobile phone features like Bluetooth or Messaging (SMS) can do digital money transactions in offline mode (for the time being) at customer end", "Sophisticated threats like Man-in-the-Browser or Man-in-the-Middle attacks intercept online transactions by reading payment data from the Mobile Wallets while the user is typing his credit card or bank account details. Phishing attacks are used to steal users' login details and personal data, making e-wallet accounts susceptible to fraud."};
    int images[] = {R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus, R.drawable.plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackthon8);
        listView = findViewById(R.id.listView);
        // now create an adapter class

        hackthon8.MyAdapter adapter = new hackthon8.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(hackthon8.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon8.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon8.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon8.this, "", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(hackthon8.this, "GO..#INCLUDE", Toast.LENGTH_SHORT).show();
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
