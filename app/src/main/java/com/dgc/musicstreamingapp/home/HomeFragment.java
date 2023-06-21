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
import com.dgc.musicstreamingapp.home.track.*;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class HomeFragment extends Fragment {


    private RecyclerView albumRecyclerView, artistRecyclerView, trackRecyclerView;
    private AlbumAdapter albumAdapter;
    private AlbumModel albumModel;
    private ArrayList<AlbumModel> albumModelData;


    private ArtistAdapter artistAdapter;
    private ArtistModel artistModel;
    private ArrayList<ArtistModel> artistModelArrayList;
    private List<ArtistResponseModel> artistList;


    private TrackAdapter trackAdapter;
    private TrackModel trackModel;
    private List<TrackResponseModel> trackList;
    private ArrayList<TrackModel>   trackModelArrayList;


// api instances
    private ApiClient apiClient;
    private Retrofit retrofit;

    private List<String> namesStringList;
    private List<String> artistNameStringList;
    private List<String> artistIdStringList;
    private List<String> artistUrlStringList;


    private List<String> imagesUrlStringList;
    private List<AlbumResponseModel> albumList;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);


//        album creation
        albumRecyclerView = view.findViewById(R.id.albumRecyclerView);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //        artist Creation
        artistRecyclerView =view.findViewById(R.id.artistRecyclerView);
        artistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        track creation
        trackRecyclerView=view.findViewById(R.id.trackRecyclerView);
        trackRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        getAlbumsApi();
        getArtistApi();
        getTracksApi();

        return view;
    }

    private void createArtist(){
        getArtistList();
        artistAdapter=new ArtistAdapter(artistModelArrayList);
        artistRecyclerView.setAdapter(artistAdapter);
    }
    private void getArtistList() {
        artistModelArrayList = new ArrayList<>();
        try {
            for (int i = 0; i < artistNameStringList.size(); i++) {
                artistModel = new ArtistModel(artistNameStringList.get(i), artistUrlStringList.get(i));
                artistModelArrayList.add(artistModel);
            }
        }catch (Exception e){
            System.out.println("artist error "+ e);
        }
//    }
    }
    private void getArtistApi(){
        Call<GetArtistResponse> artistResponseCall=apiClient.getArtists("2w9zwq3AktTeYYMuhMjju8,2w9zwq3AktTeYYMuhMjju8,2w9zwq3AktTeYYMuhMjju8,2w9zwq3AktTeYYMuhMjju8");
        artistResponseCall.enqueue(new Callback<GetArtistResponse>() {

            @Override
            public void onResponse(Call<GetArtistResponse> call, Response<GetArtistResponse> response) {
                if(response.isSuccessful()){
                    System.out.println("response 200 artist");

                    GetArtistResponse getArtistResponse=response.body();

                    artistList=getArtistResponse.getArtistsList();

                    artistNameStringList=new ArrayList<>();
                    artistIdStringList=new ArrayList<>();
                    artistUrlStringList=new ArrayList<>();

                    for(ArtistResponseModel ar:artistList){
                        artistNameStringList.add(ar.getArtistName());
                        for(ImagesResponseModel ai: ar.getArtistImagesList()){
                            artistUrlStringList.add(ai.getImageUrl());
                            System.out.println(ar.getArtistName()+" "+ai.getImageUrl());
                        }
                    }
                    createArtist();
                    System.out.println("artist success");
                }else{
                    System.out.println("error "+response.code());
                }
            }

            @Override
            public void onFailure(Call<GetArtistResponse> call, Throwable t) {
                System.out.println(call+" "+ t);
            }
        });
    }


    private void createAlbum(){
        getAlbumList();
        albumAdapter = new AlbumAdapter(albumModelData);
        albumRecyclerView.setAdapter(albumAdapter);
    }
    private void getAlbumList() {
        albumModelData=new ArrayList<>();
        for(int i = 0; i< namesStringList.size(); i++){
            albumModel=new AlbumModel(namesStringList.get(i), imagesUrlStringList.get(i));
            albumModelData.add(albumModel);
        }
    }
    private void getAlbumsApi(){

        retrofit= APIHelper.getInstance();
        apiClient=retrofit.create(ApiClient.class);

        Call<GetAlbumResponse> albumResponseCall=apiClient.getAlbums("3IBcauSj5M2A6lTeffJzdv,3IBcauSj5M2A6lTeffJzdv,3IBcauSj5M2A6lTeffJzdv,3IBcauSj5M2A6lTeffJzdv");
        albumResponseCall.enqueue(new Callback<GetAlbumResponse>() {
            @Override
            public void onResponse(Call<GetAlbumResponse> call, Response<GetAlbumResponse> response) {
                if(response.isSuccessful()){

                    GetAlbumResponse getAlbumResponse=response.body();
                    albumList =getAlbumResponse.getAlbumsList();

                    namesStringList = new ArrayList<>();
                    imagesUrlStringList = new ArrayList<>();
                    // retriving data from response
                    for(AlbumResponseModel al: albumList){
                        for(ImagesResponseModel ai:al.getImagesList()){
                            if(ai.getHeight()==300){
                                namesStringList.add(al.getAlbumName());
                                imagesUrlStringList.add((ai.getImageUrl()));
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


    private void createTrack(){
        trackAdapter=new TrackAdapter(trackModelArrayList);
        trackRecyclerView.setAdapter(trackAdapter);
    }

    private void getTracksApi(){
        Call<GetTrackResponse> trackResponseCall=apiClient.getTracks("4WNcduiCmDNfmTEz7JvmLv,4WNcduiCmDNfmTEz7JvmLv,4WNcduiCmDNfmTEz7JvmLv,4WNcduiCmDNfmTEz7JvmLv");
        trackResponseCall.enqueue(new Callback<GetTrackResponse>() {
            @Override
            public void onResponse(Call<GetTrackResponse> call, Response<GetTrackResponse> response) {
                if(response.isSuccessful()){
                    GetTrackResponse getTrackResponse=response.body();

                    trackList=getTrackResponse.getTrackList();
                    trackModelArrayList=new ArrayList<>();

                    int count=0;

                    for(TrackResponseModel t:trackList){
                        System.out.println(t.getTrackid() + " "+t.getTrackName());
                        trackModel=new TrackModel(t.getTrackName(),"artist","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8PbF8U_pNnvZXSR9X-04GlUlT2MdQ29YfOA&usqp=CAU");
                        trackModelArrayList.add(trackModel);
                        System.out.println("no of tracks "+count+1);
                    }
                    createTrack();
                }else {
                    Log.e("response error","response code"+response.code());
                }
            }
            @Override
            public void onFailure(Call<GetTrackResponse> call, Throwable t) {
                Log.e("api error","api error failure "+call);
            }
        });
    }
}
