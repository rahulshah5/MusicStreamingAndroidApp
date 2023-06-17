package com.dgc.musicstreamingapp.home;



import android.os.Bundle;
import com.dgc.musicstreamingapp.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dgc.musicstreamingapp.home.album.AlbumMainActivity;



public class HomeActivity extends AppCompatActivity{


    public void onHomeCreate() {


        AlbumMainActivity albumMainActivity=new AlbumMainActivity();
        albumMainActivity.onAlbumCreate();

        HomeFragmentManager fragmentManagerExample = new HomeFragmentManager();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.albumContainer, fragmentManagerExample);
        transaction.commit();
    }
}
