package com.androidyug.nitin.parsetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        // params this, application_id, client_id
        Parse.initialize(this, "jLrlfXlaKpqB4qbl25EzPqVquPti7EuY334HFecB", "hdcnw67K9pensgJCqzVdzhppE0ZcPXVuIMjPXA1K");

        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        } else {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }


}
