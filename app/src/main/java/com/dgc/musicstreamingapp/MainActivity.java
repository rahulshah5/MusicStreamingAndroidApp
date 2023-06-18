package com.dgc.musicstreamingapp;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dgc.musicstreamingapp.home.HomeActivity;


public class MainActivity extends AppCompatActivity {
    private HomeActivity homeActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeActivity = new HomeActivity();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeActivity).commit();
    }
}
