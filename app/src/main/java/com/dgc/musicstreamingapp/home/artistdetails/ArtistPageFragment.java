package com.dgc.musicstreamingapp.home.artistdetails;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.R;

import com.dgc.musicstreamingapp.api.helper.APIHelper;
import com.dgc.musicstreamingapp.api.helper.ApiClient;
import com.dgc.musicstreamingapp.api.response.ArtistDetails.*;
import com.dgc.musicstreamingapp.home.artists.ArtistAdapter;
import com.dgc.musicstreamingapp.api.response.*;
import com.dgc.musicstreamingapp.home.album.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArtistPageFragment extends Fragment {
    private RecyclerView recyclerView;
    private ApiClient apiClient;
    private Retrofit retrofit;

    private List<ReleasesModel> itemsList;
    private GetAlbumResponse getAlbumResponse;
    private List<AlbumResponseModel> albumList;
    private AlbumModel albumModel;
    private AlbumAdapter albumAdapter;
    private ArrayList<AlbumModel> albumModelArrayList;

    private ImageView aritstCoverImageView;
    private TextView artistNameTextView,artistPopularity,artistGenres;
    public List<String> albumsIds;
    public String albumIdCombined;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.artist_page,container,false);

        retrofit = APIHelper.getInstance();
        apiClient = retrofit.create(ApiClient.class);

        artistNameTextView=view.findViewById(R.id.artistPageTitleTextView);
        aritstCoverImageView=view.findViewById(R.id.artistPageCoverImageView);
        artistGenres=view.findViewById(R.id.artistPageGenresTextView);
        artistPopularity=view.findViewById(R.id.artistPagePopularityTextView);

        artistNameTextView.setText(ArtistAdapter.artistName);
        String rank="Popularity: "+ ArtistAdapter.artistPopularity;
        artistPopularity.setText(rank);
        artistGenres.setText(ArtistAdapter.artistGenres.toString());

        Picasso.get().load(ArtistAdapter.artistImageUrl).into(aritstCoverImageView);

        recyclerView=view.findViewById(R.id.albumPageTrackRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        getAllAlbumId();

        System.out.println(1);


        return view;
    }

     void getAllAlbumId(){


        albumsIds=new ArrayList<>();
        Call<AlbumIdOfArtistModel> albumIdOfArtistModelCall=apiClient.getArtistOverview(ArtistAdapter.artistId);
        albumIdOfArtistModelCall.enqueue(new Callback<AlbumIdOfArtistModel>() {
            @Override
            public void onResponse(Call<AlbumIdOfArtistModel> call, Response<AlbumIdOfArtistModel> response) {
                if (response.isSuccessful()){
                    itemsList=new ArrayList<>();

                    AlbumIdOfArtistModel albumIdList=response.body();
                    itemsList =albumIdList.getDataList().getArtistDetailsList().getRelatedContentModelsList().getAppearsOn().getItems();
                    System.out.println("itemlist "+itemsList);
                    for (ReleasesModel releasesModel :itemsList){
                        for(AlbumResponseModel al:releasesModel.getAlbumItemsModelList().getAlbumResponseModelList()){
                            albumsIds.add(al.getAlbumId());
                            System.out.println(al.getAlbumName());
                        }
                    }
//                    getAlbumsWithId();
                }
            }

            @Override
            public void onFailure(Call<AlbumIdOfArtistModel> call, Throwable t) {

            }
        });
//    }
//
//    void getAlbumsWithId(){
        albumIdCombined="";
        int count=0;
        for (String s:albumsIds){
            count+=1;
            if(count!=albumsIds.size()){
                albumIdCombined=s+",";
            }else {
                albumIdCombined+=s;
            }
            System.out.println("album ids "+albumIdCombined);
        }

        Call<GetAlbumResponse> albumResponseCall = apiClient.getAlbums(albumIdCombined);
        albumResponseCall.enqueue(new Callback<GetAlbumResponse>() {
            @Override
            public void onResponse(Call<GetAlbumResponse> call, Response<GetAlbumResponse> response) {
                if (response.isSuccessful()) {

                    getAlbumResponse = response.body();
                    albumList = getAlbumResponse.getAlbumsList();

                    albumModelArrayList=new ArrayList<>();
                    // retriving data from response
                    for (AlbumResponseModel al : albumList) {
                        albumModel=new AlbumModel(al.getAlbumName(),al.getImagesList().get(0).getImageUrl(),al.getArtistsList().get(0).getArtistName());
                        albumModelArrayList.add(albumModel);
                    }
                    recyclerView.setAdapter(albumAdapter);
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
}
