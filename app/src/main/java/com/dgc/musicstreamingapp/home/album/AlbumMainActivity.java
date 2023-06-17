package com.dgc.musicstreamingapp.home.album;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.R;

import java.util.ArrayList;

public  class AlbumMainActivity extends AppCompatActivity {

    private RecyclerView albumRecyclerView;
    private AlbumAdapter adapter;
    private ArrayList<AlbumModel> albumModelData;


    public void onAlbumCreate(){

        albumRecyclerView=findViewById(R.id.albumRecyclerView);
        initData();
        adapter=new AlbumAdapter(albumModelData);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AlbumMainActivity.this,
                LinearLayoutManager.VERTICAL, false);

        albumRecyclerView.setLayoutManager(linearLayoutManager);
        albumRecyclerView.setAdapter(adapter);

    }

    private void initData(){
        albumModelData=new ArrayList<>();
        for(int i=1;i<=5;i++){
            AlbumModel albumModel=new AlbumModel("album name","artist name"," ");
        }

    }
}
