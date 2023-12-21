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
import com.dgc.musicstreamingapp.home.playlist.*;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class HomeFragment extends Fragment {


    private RecyclerView albumRecyclerView, artistRecyclerView, trackRecyclerView;

    //    album
    private AlbumAdapter albumAdapter;
    private AlbumModel albumModel;
    private ArrayList<AlbumModel> albumModelData;

    //  artist
    private ArtistAdapter artistAdapter;
    private ArtistModel artistModel;
    private ArrayList<ArtistModel> artistModelArrayList;
    private List<ArtistResponseModel> artistList;

    //  tracks
    private TrackAdapter trackAdapter;
    private TrackModel trackModel;
    private List<TrackResponseModel> trackList;
    private ArrayList<TrackModel> trackModelArrayList;


    //    playlist
    private PlaylistAdapter playlistAdapter;
    private PlaylistModel playlistModel;


    // api instances
    private ApiClient apiClient;
    private Retrofit retrofit;

    private List<String> namesStringList;
    private List<String> artistNameStringList;
    private List<String> artistIdStringList;
    private List<String> artistUrlStringList;

    private List<String> idStringList;
    private List<String> imagesUrlStringList;
    private List<AlbumResponseModel> albumList;
    public static String albumIdList ="1t1gWslYejaaqicumEbdKU,2jOri0TbmcmX1EtpK991Qd,3z9dtYRTqxHyYUkReOmfJ9,37nWpT1gls52Tu6pymuPw3";
    public static String trackIdList="2o369pYSsztrzKYyVW9tqi,1418IuVKQPTYqt7QNJ9RXN,46gD3xI2JOg3K9YkrfW1JQ,606UwPF1MMoE220tv9ITut,4nriYsKSq1VmiamjZOB4Tp";
    public static String artistIdList ="4YRxDV8wJFPHPTeXepOstw,1o3w6uL4JCuQX19stjhf3F,7L463cv1boHIHSwm8aWebX,1m98lRsSVX0l8vVaWkRwhD";
    public GetAlbumResponse getAlbumResponse;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);


//        album creation
        albumRecyclerView = view.findViewById(R.id.albumRecyclerView);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //        artist Creation
        artistRecyclerView = view.findViewById(R.id.artistRecyclerView);
        artistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        track creation
        trackRecyclerView = view.findViewById(R.id.trackRecyclerView);
        trackRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        retrofit = APIHelper.getInstance();
        apiClient = retrofit.create(ApiClient.class);

        getAlbumsApi();
        getArtistApi();
        getTracksApi();


        return view;
    }

    //    Artist functions
    private void createArtist() {
        artistAdapter = new ArtistAdapter(artistModelArrayList,getContext());
        artistRecyclerView.setAdapter(artistAdapter);
    }

//    private void getArtistList() {
//        artistModelArrayList = new ArrayList<>();
//        try {
//            for (int i = 0; i < artistNameStringList.size(); i++) {
//                artistModel = new ArtistModel(artistNameStringList.get(i), artistUrlStringList.get(i),artistIdStringList.get(i),);
//                artistModelArrayList.add(artistModel);
//            }
//        } catch (Exception e) {
//            System.out.println("artist error " + e);
//        }
//    }

    private void getArtistApi() {
        Call<GetArtistResponse> artistResponseCall = apiClient.getArtists(artistIdList);
        artistResponseCall.enqueue(new Callback<GetArtistResponse>() {

            @Override
            public void onResponse(Call<GetArtistResponse> call, Response<GetArtistResponse> response) {
                if (response.isSuccessful()) {
                    GetArtistResponse getArtistResponse = response.body();
                    artistList = getArtistResponse.getArtistsList();

                    artistModelArrayList=new ArrayList<>();
                    for (ArtistResponseModel ar : artistList) {
                        artistModel=new ArtistModel(ar.getArtistName(),ar.getArtistImagesList().get(0).getImageUrl(),ar.getArtistId(),ar.getGenres(),ar.getPopularityRank());
                        artistModelArrayList.add(artistModel);
                    }
                    createArtist();
                } else {
                    System.out.println("error " + response.code());
                }
            }

            @Override
            public void onFailure(Call<GetArtistResponse> call, Throwable t) {
                System.out.println(call + " " + t);
            }
        });
    }

    // Album functions
    private void createAlbum() {
        getAlbumList();
        albumAdapter = new AlbumAdapter(albumModelData, getAlbumResponse, getContext());
        albumRecyclerView.setAdapter(albumAdapter);
    }

    private void getAlbumList() {
        albumModelData = new ArrayList<>();
        for (int i = 0; i < namesStringList.size(); i++) {
            albumModel = new AlbumModel(namesStringList.get(i), imagesUrlStringList.get(i), artistNameStringList.get(i));
            albumModelData.add(albumModel);
        }
    }

    public  void getAlbumsApi() {


        Call<GetAlbumResponse> albumResponseCall = apiClient.getAlbums(albumIdList);
        albumResponseCall.enqueue(new Callback<GetAlbumResponse>() {
            @Override
            public void onResponse(Call<GetAlbumResponse> call, Response<GetAlbumResponse> response) {
                if (response.isSuccessful()) {

                    getAlbumResponse = response.body();
                    albumList = getAlbumResponse.getAlbumsList();

                    namesStringList = new ArrayList<>();
                    imagesUrlStringList = new ArrayList<>();
                    idStringList = new ArrayList<>();
                    artistNameStringList = new ArrayList<>();
                    // retriving data from response
                    for (AlbumResponseModel al : albumList) {
                        for (ImagesResponseModel ai : al.getImagesList()) {
                            if (ai.getHeight() == 300) {
                                namesStringList.add(al.getAlbumName());
                                imagesUrlStringList.add((ai.getImageUrl()));
                            }
                        }
                        List<ArtistResponseModel> ar = al.getArtistsList();
                        artistNameStringList.add(ar.get(0).getArtistName());
                        idStringList.add(al.getAlbumId());
                    }
                    createAlbum();
                } else {
                    Log.e("API Error", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<GetAlbumResponse> call, Throwable t) {
                System.out.println("error on api call" + " " + t + "\n" + call);
            }

        });
    }


    //    Track functions
    private void createTrack() {
        trackAdapter = new TrackAdapter(trackModelArrayList, getContext());
        trackRecyclerView.setAdapter(trackAdapter);
    }

    private void getTracksApi() {
        Call<GetTrackResponse> trackResponseCall = apiClient.getTracks(trackIdList);
        trackResponseCall.enqueue(new Callback<GetTrackResponse>() {
            @Override
            public void onResponse(Call<GetTrackResponse> call, Response<GetTrackResponse> response) {
                if (response.isSuccessful()) {
                    GetTrackResponse getTrackResponse = response.body();

                    trackList = getTrackResponse.getTrackList();
                    trackModelArrayList = new ArrayList<>();

                    for (TrackResponseModel t : trackList) {
                        trackModel = new TrackModel(t.getTrackName(), "artist", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8PbF8U_pNnvZXSR9X-04GlUlT2MdQ29YfOA&usqp=CAU",t.getTrackUrl(),t.getDuration());
                        trackModelArrayList.add(trackModel);
                    }
                    createTrack();
                } else {
                    Log.e("response error", "response code" + response.code());
                }
            }

            @Override
            public void onFailure(Call<GetTrackResponse> call, Throwable t) {
                Log.e("api error", "api error failure " + call);
            }
        });
    }




//    playlist functions

////   private void getPlaylistApi(){
//        Call<GetPlaylistResponse> getPlaylistResponse= apiClient.getPlaylist("37i9dQZF1DX4Wsb4d7NKfP,37i9dQZF1DX4Wsb4d7NKfP,37i9dQZF1DX4Wsb4d7NKfP,37i9dQZF1DX4Wsb4d7NKfP");
//
//        getPlaylistResponse.enqueue(new Callback<GetPlaylistResponse>() {
//            @Override
//            public void onResponse(Call<GetPlaylistResponse> call, Response<GetPlaylistResponse> response) {
//                if(response.isSuccessful()){
//                    GetPlaylistResponse getPlaylistResponse1=response.body();
//                    playlistModel=new PlaylistModel(getPlaylistResponse1.getPlaylistName(),getPlaylistResponse1.getImagesList().get(0).getImageUrl());
//                    System.out.println(getPlaylistResponse1.getPlaylistName()+" "+getPlaylistResponse1.getImagesList().get(0).getImageUrl());
//                    playlistAdapter=new PlaylistAdapter(playlistModel);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GetPlaylistResponse> call, Throwable t) {
//
//            }
//        });
//    }

}
