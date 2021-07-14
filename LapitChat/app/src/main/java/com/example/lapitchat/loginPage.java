package com.example.lapitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginPage extends AppCompatActivity {

    private TextInputEditText mail;
    private TextInputEditText pass;

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
    //Fire Base
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
     sharedPreferences=getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
     editor=sharedPreferences.edit();
        process=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        mail=(TextInputEditText)findViewById(R.id.mail);
        rem_use=findViewById(R.id.checkBox);
        pass=(TextInputEditText)findViewById(R.id.password);

        getPreferencesData();

        //if(sharedPreferences.getBoolean(KEY_REMEMBER,false))
        //    rem_use.setChecked(true);
       // else
       //     rem_use.setChecked(false);
       // mail.setText(sharedPreferences.getString(KEY_USERNAME,""));
       // pass.setText(sharedPreferences.getString(KEY_PASS,""));

       // mail.addTextChangedListener( this);
       // pass.addTextChangedListener((TextWatcher) this);
      //  rem_use.addTextChangedListener((TextWatcher) this);

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
process.dismiss();
                            Intent intent=new Intent(loginPage.this,checkyouruid.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                            mail.getText().clear();
                            pass.getText().clear();

                            finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            process.hide();
                            Toast.makeText(loginPage.this, "Authentication failed.",
                                    Toast.LENGTH_LONG).show();

                        }

                        // ...
                    }
                });



    }
}
