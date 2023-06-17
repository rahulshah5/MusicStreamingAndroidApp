package com.dgc.musicstreamingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dgc.musicstreamingapp.R;
import com.dgc.musicstreamingapp.home.HomeActivity;
import com.dgc.musicstreamingapp.home.album.AlbumMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeActivity homeActivity=new HomeActivity();
        homeActivity.onHomeCreate();
    }
}
