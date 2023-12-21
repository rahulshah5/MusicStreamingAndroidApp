package com.dgc.musicstreamingapp;

import android.os.Bundle;
import android.view.MenuItem;


import com.dgc.musicstreamingapp.player.PlayerFragment;
import com.dgc.musicstreamingapp.home.Search.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dgc.musicstreamingapp.home.artistdetails.*;
import com.dgc.musicstreamingapp.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.dgc.musicstreamingapp.home.albumdetails.*;
import com.dgc.musicstreamingapp.player.*;
import com.dgc.musicstreamingapp.home.track.*;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;

    private AlbumDetailsFragment albumDetailsFragment;
    private BottomNavigationView bottomNavigationView;
    private ArtistPageFragment artistPageFragment;
    private PlayerFragment playerFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragment initiated
        playerFragment=new PlayerFragment();
        searchFragment=new SearchFragment();

//      making home fragment default
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        bottomNavigationMenu();

    }

    private void bottomNavigationMenu(){

        //  navigatoin menu functions
        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if(item.getItemId()==R.id.searchPage){
                    System.out.println(item.getItemId()+" "+R.id.searchPage);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment).commit();
                    return true;
                } else if (item.getItemId()==R.id.ExplorePage) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                } else if (item.getItemId()==R.id.playerPage) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,playerFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }

    public void onClickAlbumItem(){
        PlayerFragment.trackUrl=AlbumDetailsAdapter.trackUrl;
        PlayerFragment.trackDuration=AlbumDetailsAdapter.trackDuration;
        PlayerFragment.trackName=AlbumDetailsAdapter.trackName;
        albumDetailsFragment=new AlbumDetailsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,albumDetailsFragment).commit();

    }

    public void onClickArtistItem(){
        artistPageFragment=new ArtistPageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,artistPageFragment).commit();
    }

    public void onClickTrackItem(){
        PlayerFragment.trackUrl=TrackAdapter.trackUrl;
        PlayerFragment.trackDuration=TrackAdapter.trackDuration;
        PlayerFragment.trackName=TrackAdapter.trackName;
        playerFragment=new PlayerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,playerFragment).commit();
    }

    public void onClickAlbumTrackItem(){
        playerFragment.trackUrl=AlbumDetailsAdapter.trackUrl;
        playerFragment=new PlayerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,playerFragment).commit();

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);

        // Determine the fragment to display based on the current fragment
        Fragment newFragment;
        if (currentFragment instanceof AlbumDetailsFragment || currentFragment instanceof ArtistPageFragment) {
            newFragment = new HomeFragment();
        } else {
            super.onBackPressed();
            return;
        }

        replaceFragment(newFragment);
    }


}
