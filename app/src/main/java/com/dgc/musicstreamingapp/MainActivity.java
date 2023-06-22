package com.dgc.musicstreamingapp;

import android.os.Bundle;
import android.view.MenuItem;


import com.dgc.musicstreamingapp.search.*;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.dgc.musicstreamingapp.library.*;
import com.dgc.musicstreamingapp.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private LibraryFragment libraryFragment;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragment initiated
        searchFragment=new SearchFragment();
        libraryFragment=new LibraryFragment();

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
                } else if (item.getItemId()==R.id.libraryPage) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,libraryFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }

}
