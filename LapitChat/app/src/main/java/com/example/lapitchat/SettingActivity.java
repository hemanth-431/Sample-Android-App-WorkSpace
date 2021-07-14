package com.example.lapitchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private TextView textView;

    private ProgressDialog progressDialog;
    private static final int GALARY_PIC = 1;
    private TextView status;
    private Button button;
    private StorageReference storageReference;
    private Button button1;
    private CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        circleImageView = findViewById(R.id.image);
        textView = findViewById(R.id.textView2);
        status = (TextView) findViewById(R.id.status);
        storageReference = FirebaseStorage.getInstance().getReference();
        button = findViewById(R.id.button4);
        button1 = findViewById(R.id.button5);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentid = firebaseUser.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                String image = dataSnapshot.child("image").getValue().toString();
                String stat = dataSnapshot.child("status").getValue().toString();
                String thumbimage = dataSnapshot.child("thumb image").getValue().toString();

                status.setText(stat);
                textView.setText(name);
                if (!image.equals("default")) {
                    Picasso.with(SettingActivity.this).load(image).into(circleImageView);
                    circleImageView.setImageURI(Uri.parse(image));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = status.getText().toString();
                Intent intent = new Intent(SettingActivity.this, StatusActivity.class);
                intent.putExtra("status", s);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gall=new Intent();
                gall.setType("image/*");
                gall.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gall,"Select image"),GALARY_PIC);

             //   CropImage.activity()
                //        .setGuidelines(CropImageView.Guidelines.ON)
                  //      .start(SettingActivity.this);


            }
        });


    }


   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALARY_PIC && resultCode == RESULT_OK) {

           Uri uriid = data.getData();

            CropImage.activity(uriid)
                   .setAspectRatio(1, 1)
                   .start(this);

        }
       if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            final CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                progressDialog = new ProgressDialog(SettingActivity.this);
                progressDialog.setTitle("Uploading Image....");
                progressDialog.setMessage("On Progress...Please Whait while we appload");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                Uri resultUri = result.getUri();
                String currentUser = firebaseUser.getUid();
                StorageReference store = storageReference.child("profile_images").child(currentUser + ".jpg");
                store.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        if (task.isSuccessful()) {

                            String download_url = task.getResult().getStorage().getDownloadUrl().toString();
                            databaseReference.child("image").setValue(download_url).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
if(task.isSuccessful()){
    progressDialog.hide();
    Toast.makeText(SettingActivity.this,"Sucess",Toast.LENGTH_LONG);
}
                                }
                            });

                        } else {
                            Toast.makeText(SettingActivity.this, "Error", Toast.LENGTH_LONG);
                        }
                    }
                });


            } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                progressDialog.dismiss();
                Exception error = result.getError();
            }

        }
    }

}

    /*public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(20);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
    }*/


