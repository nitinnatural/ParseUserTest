package com.androidyug.nitin.parsetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    private EditText mNameEt;
    private EditText mEmailEt;
    private EditText mPasswordEt;
    private Button mSignUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        

        mNameEt = (EditText) findViewById(R.id.etName);
        mEmailEt = (EditText) findViewById(R.id.etEmail);
        mPasswordEt = (EditText) findViewById(R.id.etPassword);
        mSignUpBtn = (Button) findViewById(R.id.btnSignUp);


        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEt.getText().toString().trim();
                String email = mEmailEt.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();

                ParseUser user = new ParseUser();
                user.setUsername(name);
                user.setEmail(email);
                user.setPassword(password);


                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            Toast.makeText(RegisterActivity.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error: " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}
