package com.klef.includeklu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;
import java.util.Map;


public class profile extends AppCompatActivity {
    TextView name,email;
private FirebaseAuth firebaseAuth;
private FirebaseFirestore firebaseFirestore;
private String userid;
private Button button;
private Button image;
private ImageView imageView;
private Button save;
private Uri imageuri=null;
private Bitmap compressor;
private StorageReference storageReference;
private String str;
private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    //    name=findViewById(R.id.Name);
      //  email=findViewById(R.id.email);
        image=findViewById(R.id.button7);
        save=findViewById(R.id.button8);
        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.button6);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        userid=firebaseAuth.getCurrentUser().getUid();

      /*  str=firebaseAuth.getCurrentUser().getUid();
        DocumentReference documentReference=firebaseFirestore.collection("Users").document(str);
        Map<String,Object> users=new HashMap<>();
        users.put("Login","success");
        documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(profile.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });  */
        user=firebaseAuth.getCurrentUser().getUid();
      /*  DocumentReference documentReference=firebaseFirestore.collection("Users").document(user);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
             //   name.setText("Hemanth");

                  String s=documentSnapshot.getString("FullName");
                String s1=documentSnapshot.getString("MailId");
                if(s!=null)
                {  name.setText(documentSnapshot.getString("FullName"));}
                else {
                    name.setText("User");
                }
                if(s1!=null)
                {
                email.setText(documentSnapshot.getString("MailId"));}
                else {
            name.setText("Voice Mail");
            }

              //  email.setText("Ho");
            }
        });*/
image.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(ContextCompat.checkSelfPermission(profile.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(profile.this,"PermisionDenied",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(profile.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
            else {
ChoseImage();
            }

        }
        else
        {
            ChoseImage();
        }
    }
});
/*save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(imageuri!=null) {
            File newfile = new File(imageuri.getPath());
            try {
                compressor=new Compressor(profile.this)
                        .setMaxHeight(125)
                        .setMaxWidth(125)
                        .setQuality(50)
                        .compressToBitmap(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            compressor.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            byte[] thumb=byteArrayOutputStream.toByteArray();
            UploadTask image_path=storageReference.child("Image").child(userid+".jpg").putBytes(thumb);
            image_path.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful())
                    {
   storeusersdata(task);
                    }
                    else
                    {
String error=task.getException().getMessage();

Toast.makeText(profile.this,"Image Error"+error,Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }
});*/

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseAuth.getInstance().signOut();
        Intent start=new Intent(profile.this,MainActivity.class);
        startActivity(start);
        finish();
    }
});


    }

    private void storeusersdata(Task<UploadTask.TaskSnapshot> task)
    {
       Task<Uri> down = null;
        if(task!=null)
        {
           down= task.getResult().getStorage().getDownloadUrl();

        }
        else {

           Toast.makeText(this,"Please Select Image",Toast.LENGTH_LONG).show();//down=imageuri;
        }
        Map<String,String> userdata=new HashMap<>();
        userdata.put("Image",down.toString());
        firebaseFirestore.collection("Users").document(userid).set(userdata).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
Toast.makeText(profile.this,"Successfully Image Stored",Toast.LENGTH_LONG).show();

                }
                else {
Toast.makeText(profile.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
        {

        }
    }
public void ChoseImage()
{
    Toast.makeText(this,"Choose Image",Toast.LENGTH_LONG).show();
    CropImage.activity().setGuidelines(CropImageView.Guidelines.ON)
            .setAspectRatio(1,1)
            .start(profile.this);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result=CropImage.getActivityResult(data);
            if(resultCode==RESULT_OK){
                imageuri=result.getUri();
                str=firebaseAuth.getCurrentUser().getUid();
                DocumentReference documentReference=firebaseFirestore.collection("Users").document(str);
                Map<String,Object> users=new HashMap<>();
                users.put("Login","success");
                documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(profile.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });
                imageView.setImageURI(imageuri);


            }
            else if (resultCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error=result.getError();
            }
        }
    }
}
