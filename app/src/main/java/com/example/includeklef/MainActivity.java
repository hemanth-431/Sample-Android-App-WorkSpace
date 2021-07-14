package com.example.includeklef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText mail;
    private TextInputEditText pass;
    private Button button2;
    private TextView button4;
    private TextView link;
    private Button button;
    private Toolbar toolbar;
    private CheckBox rem_use;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private  static final String PREFS_NAME="prefs";
    private  static final String KEY_REMEMBER="remember";
    private  static final String KEY_USERNAME="username";
    private  static final String KEY_PASS="password";
    private ProgressDialog process;
    private FirebaseAuth mAuth;
    public String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        process=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null)
        {
            finish();
            startActivity(new Intent(MainActivity.this,HomePage.class));
        }
link=findViewById(R.id.link);
        button4=findViewById(R.id.button2);
        mail=(TextInputEditText)findViewById(R.id.mail);
        rem_use=findViewById(R.id.checkBox);
        pass=(TextInputEditText)findViewById(R.id.password);

        getPreferencesData();

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,forgetpassword.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process.setTitle("Logging in");
                process.setTitle("Wait a second!");
                process.setCanceledOnTouchOutside(false);
                process.show();

                String mail1=mail.getText().toString();
                String pass1=pass.getText().toString();
                if(!TextUtils.isEmpty(mail1) || !TextUtils.isEmpty(pass1))
                { registor(mail1,pass1);}
            }
        });
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri uri = Uri.parse("https://klhashinclude.in/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void getPreferencesData() {
        SharedPreferences sp=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        if(sp.contains("pref_name")){
            String u=sp.getString("pref_name","not found.");
            mail.setText(u.toString());
        }
        if(sp.contains("pref_pass")){
            String p=sp.getString("pref_pass","not found");
            pass.setText(p.toString());
        }
        if(sp.contains("pref_check")){
            Boolean b=sp.getBoolean("pref_check",false);
            rem_use.setChecked(b);

        }
    }

    private void registor(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if(mAuth.getCurrentUser().isEmailVerified())
                            {
                                process.dismiss();
                                Intent intent=new Intent(MainActivity.this,HomePage.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(MainActivity.this,"Please Check Your Mail!",Toast.LENGTH_LONG).show();
                            }





                            if(rem_use.isChecked()){
                                Boolean boolischecked=rem_use.isChecked();
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("pref_name",mail.getText().toString());
                                editor.putString("pref_pass",pass.getText().toString());
                                editor.putBoolean("pref_check",boolischecked);
                                editor.apply();
                            }
                            else
                            {
                                sharedPreferences.edit().clear().apply();
                            }
                            // Sign in success, update UI with the signed-in user's information


                            mail.getText().clear();
                            pass.getText().clear();

                            finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            process.hide();
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });

    }
}
