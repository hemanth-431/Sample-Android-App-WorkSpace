package com.example.lapitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;


public class UsersActivity extends AppCompatActivity {
private Toolbar toolbar;
private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        toolbar=(Toolbar)findViewById(R.id.toolbsr);
        getSupportActionBar().setTitle("All Users");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true );

        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.usersview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

 //   @Override
 //   protected void onStart() {
 //       super.onStart();
//        FirebaseRecyclerAdapter<>
 //   }

    public class usersviewholder extends RecyclerView.ViewHolder{

        View mview;
        public usersviewholder(@NonNull View itemView) {
            super(itemView);
            mview=itemView;
        }
    }
}
