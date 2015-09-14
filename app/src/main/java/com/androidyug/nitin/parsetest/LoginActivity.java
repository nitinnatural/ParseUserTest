package com.androidyug.nitin.parsetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginBtn;
    private Button mNewUserBtn;
    private TextView mResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mUsername = (EditText) findViewById(R.id.etUsername);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mLoginBtn = (Button) findViewById(R.id.btnLogin);
        mNewUserBtn = (Button) findViewById(R.id.btnNewUser);
        mResetPassword = (TextView) findViewById(R.id.tvResetPassword);

        mResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.requestPasswordResetInBackground("nitinnatural@gmail.com", new RequestPasswordResetCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(LoginActivity.this, "Success: visit nitinnatural@gmail", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error: " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if(e == null){
                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error: " + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        mNewUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }

}
