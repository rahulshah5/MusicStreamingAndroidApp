package com.dgc.musicstreamingapp.api.helper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import com.dgc.musicstreamingapp.api.response.*;

public interface ApiClient {

    @Headers(
            "X-RapidAPI-Key: 96bb1ac5admshf4421c13f164dcfp1fc537jsn361d80d3fca4"
    )
    @GET("albums/")
    Call<GetAlbumResponse>  getAlbums(@Query("ids") String ids);


    @Headers(
            "X-RapidAPI-Key: 96bb1ac5admshf4421c13f164dcfp1fc537jsn361d80d3fca4"
    )
    @GET("tracks/")
    Call<GetTrackResponse> getTracks(@Query("ids") String ids);

    @Headers(
            "X-RapidAPI-Key: 96bb1ac5admshf4421c13f164dcfp1fc537jsn361d80d3fca4"
    )
    @GET("artists/")
    Call<GetArtistResponse> getArtists(@Query("ids") String ids);
}
