package com.dgc.musicstreamingapp.api.helper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import com.dgc.musicstreamingapp.api.response.*;

public interface ApiClient {

    @Headers(
            "X-RapidAPI-Key: a3da52ec2emsh7f1b06e20ef4024p1acf60jsnb77c2ec7f1c7"
    )
    @GET("albums/")
    Call<GetAlbumResponse>  getAlbums(@Query("ids") String ids);
}
