package com.dgc.musicstreamingapp.home;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgc.musicstreamingapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.home.album.*;

import com.dgc.musicstreamingapp.home.artists.*;
import java.util.ArrayList;


public class HomeFragment extends Fragment {


    private RecyclerView albumRecyclerView, artistRecyclerView;
    private AlbumAdapter albumAdapter;
    private AlbumModel albumModel;
    private ArrayList<AlbumModel> albumModelData;


    private ArtistAdapter artistAdapter;
    private ArtistModel artistModel;
    private ArrayList<ArtistModel> artistModelArrayList;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

//        album creation
        albumRecyclerView = view.findViewById(R.id.albumRecyclerView);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        createAlbum();

//        artist Creation
        artistRecyclerView =view.findViewById(R.id.artistRecyclerView);
        artistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        createArtist();


        return view;
    }

    private void createArtist(){
        getArtistList();
        artistAdapter=new ArtistAdapter(artistModelArrayList);
        artistRecyclerView.setAdapter(artistAdapter);

    }

    private void getArtistList(){
        artistModelArrayList=new ArrayList<>();
        for(int i=1;i<=5;i++){
            artistModel=new ArtistModel("artist "+i,"https://i.scdn.co/image/ab6761610000e5eb0261696c5df3be99da6ed3f3");
            artistModelArrayList.add(artistModel);
        }
    }
    private void createAlbum(){
        getAlbumList();
        albumAdapter = new AlbumAdapter(albumModelData);
        albumRecyclerView.setAdapter(albumAdapter);
    }
    private void getAlbumList(){
        albumModelData = new ArrayList<>();
        for(int i=1;i<=5;i++){

            albumModel=new AlbumModel("album name"+i,"https://dw0i2gv3d32l1.cloudfront.net/uploads/stage/stage_image/39631/optimized_large_thumb_stage.jpg");
            albumModelData.add(albumModel);
        }
    }
}
