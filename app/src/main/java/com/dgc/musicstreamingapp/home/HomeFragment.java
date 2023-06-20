package com.dgc.musicstreamingapp.home;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.dgc.musicstreamingapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.api.response.*;
import com.dgc.musicstreamingapp.home.album.*;
import com.dgc.musicstreamingapp.api.helper.*;
import com.dgc.musicstreamingapp.home.artists.*;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Headers;


public class HomeFragment extends Fragment {


    private RecyclerView albumRecyclerView, artistRecyclerView;
    private AlbumAdapter albumAdapter;
    private AlbumModel albumModel;
    private ArrayList<AlbumModel> albumModelData;


    private ArtistAdapter artistAdapter;
    private ArtistModel artistModel;
    private ArrayList<ArtistModel> artistModelArrayList;


// api instances
    private ApiClient apiClient;
    private Retrofit retrofit;

    private List<String> albumNamesStringList;
    private List<String> albumUrlStringList;
    private List<Album> albumList;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        getAlbumsApi();

//        album creation
        albumRecyclerView = view.findViewById(R.id.albumRecyclerView);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

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

    private void getAlbumList() {
//        albumModelData=new ArrayList<>();
//        albumModel=new AlbumModel("album a","https://static-cse.canva.com/blob/1072565/1600w-1Nr6gsUndKw.jpg");
//        albumModelData.add(albumModel);
        for(int i=0;i<albumNamesStringList.size();i++){
            albumModel=new AlbumModel(albumNamesStringList.get(i),albumUrlStringList.get(i));
            albumModelData.add(albumModel);
        }

    }

    private void getAlbumsApi(){

        retrofit= APIHelper.getInstance();
        apiClient=retrofit.create(ApiClient.class);


        Call<GetAlbumResponse> albumResponseCall=apiClient.getAlbums("3IBcauSj5M2A6lTeffJzdv");
        albumResponseCall.enqueue(new Callback<GetAlbumResponse>() {
            @Override
            public void onResponse(Call<GetAlbumResponse> call, Response<GetAlbumResponse> response) {
                if(response.isSuccessful()){
                    System.out.println("status code 200" );
                    GetAlbumResponse getAlbumResponse=response.body();
                    albumList =getAlbumResponse.getAlbumsList();
                    albumNamesStringList = new ArrayList<>();
                    albumUrlStringList = new ArrayList<>();

                    for(Album al: albumList){
                        System.out.println(al.getAlbumId()+" "+al.getAlbumName());

                        for(Album.Artist ar: al.getArtistsList()){
                            System.out.println(ar.getArtistId()+" "+ar.getArtistName());
                        }

                        for(Album.AlbumImages ai:al.getImagesList()){
                            System.out.println(ai.getImageUrl());




                            System.out.println(ai.getHeight()+" "+ai.getWidth());
                            if(ai.getHeight()==300){
                                System.out.println(ai.getImageUrl());
                                albumNamesStringList.add(al.getAlbumName());
                                albumUrlStringList.add((ai.getImageUrl()));

                            }
                        }
                    }
                    createAlbum();

                }else {
                    Log.e("API Error", "Response Code: " + response.code());
                }

            }

            @Override
            public void onFailure(Call<GetAlbumResponse> call, Throwable t) {
                System.out.println("error on api call"+ " "+t+"\n"+ call);
            }
        });

        System.out.println("function end");

    }
}
