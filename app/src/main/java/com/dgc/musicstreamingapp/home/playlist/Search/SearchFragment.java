package com.dgc.musicstreamingapp.home.playlist.Search;

import android.app.appsearch.SearchResult;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.R;
import com.dgc.musicstreamingapp.api.helper.APIHelper;
import com.dgc.musicstreamingapp.api.helper.ApiClient;
import com.dgc.musicstreamingapp.home.track.*;
import com.dgc.musicstreamingapp.api.response.*;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchFragment extends Fragment {

    private Retrofit retrofit;
    private ApiClient apiClient;
    private RecyclerView recyclerView;
    private TrackModel trackModel;
    private ArrayList<TrackModel> trackModelList;
    private TrackAdapter trackAdapter;
    private SearchResultResponseModel searchResultResponseModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_search,container,false);

        retrofit = APIHelper.getInstance();
        apiClient = retrofit.create(ApiClient.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        getSearchResult();

        return view;
    }

    void getSearchResult(){

        Call<GetSearchResponse> getSearchResponseCall=apiClient.getSearchResult("maan meri jaan","tracks");
        getSearchResponseCall.enqueue(new Callback<GetSearchResponse>() {
            @Override
            public void onResponse(Call<GetSearchResponse> call,Response<GetSearchResponse> response) {
                if(response.isSuccessful()){
                    GetSearchResponse getSearchResponse=response.body();

                    trackModelList=new ArrayList<>();
                    List<SearchResultResponseModel.ArtistData> artistData= getSearchResponse.getSearchResultResponseModel().getArtistData();

                    for(SearchResultResponseModel.ArtistData ad:artistData){
                        ad.getArtistIdName().getTrackId();
                        ad.getArtistIdName().getTrackName();
                        List<SearchResultResponseModel.ArtistProfile> ar= ad.getArtistIdName().getArtistItem().getArtistProfileList();
                        for (SearchResultResponseModel.ArtistProfile artistid:ar){
                            artistid.getArtistProfileName().getArtistName();
                            trackModel=new TrackModel(ad.getArtistIdName().getTrackName(),artistid.getArtistProfileName().getArtistName(),"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8PbF8U_pNnvZXSR9X-04GlUlT2MdQ29YfOA&usqp=CAU");
                            trackModelList.add(trackModel);
                        }
                    }
                    trackAdapter=new TrackAdapter(trackModelList);
                    recyclerView.setAdapter(trackAdapter);

                }else {
                    Log.e("response error", "response code" + response.code());
                }
            }

            @Override
            public void onFailure(Call<GetSearchResponse> call, Throwable t) {
                Log.e("api error", "api error failure " + call);
            }
        });

    }
}
