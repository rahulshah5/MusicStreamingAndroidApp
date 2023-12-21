package com.dgc.musicstreamingapp.home.Search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.R;
import com.dgc.musicstreamingapp.api.helper.APIHelper;
import com.dgc.musicstreamingapp.api.helper.ApiClient;
import com.dgc.musicstreamingapp.api.response.GetSearchResponse;
import com.dgc.musicstreamingapp.api.response.GetTrackResponse;
import com.dgc.musicstreamingapp.api.response.SearchResultResponseModel;
import com.dgc.musicstreamingapp.api.response.TrackResponseModel;
import com.dgc.musicstreamingapp.home.track.TrackAdapter;
import com.dgc.musicstreamingapp.home.track.TrackModel;

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
    private List<String> idList;
    private String combinedIdString;
    private TrackAdapter trackAdapter;
    private List<TrackResponseModel> trackList;
    private SearchView searchView;
    private Button searchButton;
    private String searchQuery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search, container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.searchPageTrackRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        retrofit = APIHelper.getInstance();
        apiClient = retrofit.create(ApiClient.class);

        searchView=view.findViewById(R.id.searchView);
        searchButton=view.findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchQuery=searchView.getQuery().toString();
                getSearchResult();
            }
        });

    }

    void getSearchResult() {

        Call<GetSearchResponse> getSearchResponseCall = apiClient.getSearchResult(searchQuery, "tracks", "0","20","5");
        getSearchResponseCall.enqueue(new Callback<GetSearchResponse>() {
            @Override
            public void onResponse(Call<GetSearchResponse> call, Response<GetSearchResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println("searched");
                    GetSearchResponse getSearchResponse = response.body();

                    trackModelList = new ArrayList<>();
                    idList = new ArrayList<>();
                    SearchResultResponseModel artistData = getSearchResponse.getSearchResultResponseModel();

//                    for (SearchResultResponseModel.ArtistData ad : artistData) {
//                        idList.add(ad.getArtistIdName().getTrackId());
//
//                    }

                    for(int i=0;i<20;i++){
                        idList.add(artistData.getArtistData().get(i).getArtistIdName().getTrackId());
                    }
                    StringBuilder stringBuilder = new StringBuilder();

                    System.out.println("id list "+idList.size());
                    for (int i = 0; i < idList.size(); i++) {
                        stringBuilder.append(idList.get(i));

                        if (i != idList.size() - 1) {
                            stringBuilder.append(", ");
                        }
                    }
                    combinedIdString = stringBuilder.toString();
                    System.out.println(combinedIdString);


                } else {
                    Log.e("response error", "response code" + response.code());
                }
                getTracksOfResult();
            }

            @Override
            public void onFailure(Call<GetSearchResponse> call, Throwable t) {
                Log.e("api error", "api error failure " + call);
            }
        });

    }

    void getTracksOfResult() {
        Call<GetTrackResponse> trackResponseCall = apiClient.getTracks(combinedIdString);
        trackResponseCall.enqueue(new Callback<GetTrackResponse>() {
            @Override
            public void onResponse(Call<GetTrackResponse> call, Response<GetTrackResponse> response) {
                if (response.isSuccessful()) {
                    GetTrackResponse getTrackResponse = response.body();

                    trackList = getTrackResponse.getTrackList();
                    trackModelList = new ArrayList<>();

                    for (TrackResponseModel t : trackList) {
                        if(t!=null) {
                            trackModel = new TrackModel(t.getTrackName(), "artist", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8PbF8U_pNnvZXSR9X-04GlUlT2MdQ29YfOA&usqp=CAU", t.getTrackUrl(), t.getDuration());
                            trackModelList.add(trackModel);
                        }
                    }
                } else {
                    Log.e("response error", "response code" + response.code());
                }
                System.out.println("track size "+trackModelList.size());
                trackAdapter = new TrackAdapter(trackModelList, getContext());
                recyclerView.setAdapter(trackAdapter);
            }

            @Override
            public void onFailure(Call<GetTrackResponse> call, Throwable t) {
                Log.e("api error", "api error failure " + call);
            }
        });
    }
}
