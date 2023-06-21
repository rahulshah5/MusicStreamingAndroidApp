package com.dgc.musicstreamingapp.topChartAPI.helper;

import com.dgc.musicstreamingapp.api.response.GetAlbumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TopChartsApiClient {

    @Headers(
            "X-RapidAPI-Key: a3da52ec2emsh7f1b06e20ef4024p1acf60jsnb77c2ec7f1c7"
    )
    @GET("new_releases/")
    Call<GetAlbumResponse> getNewReleases(@Query("country") String country);
}
