package com.dgc.musicstreamingapp.api.helper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import com.dgc.musicstreamingapp.api.response.*;
import com.dgc.musicstreamingapp.api.response.ArtistDetails.AlbumIdOfArtistModel;

public interface ApiClient {

    @Headers(
            "X-RapidAPI-Key: 0ecbca7bacmshba5f7cd7ad1a00ep1465a3jsnf6667a29d1a5"
    )
    @GET("albums/")
    Call<GetAlbumResponse>  getAlbums(@Query("ids") String ids);


    @Headers(
            "X-RapidAPI-Key: 0ecbca7bacmshba5f7cd7ad1a00ep1465a3jsnf6667a29d1a5"
    )
    @GET("tracks/")
    Call<GetTrackResponse> getTracks(@Query("ids") String ids);

    @Headers(
            "X-RapidAPI-Key: 0ecbca7bacmshba5f7cd7ad1a00ep1465a3jsnf6667a29d1a5"
    )
    @GET("artists/")
    Call<GetArtistResponse> getArtists(@Query("ids") String ids);


    @Headers(
            "X-RapidAPI-Key: 0ecbca7bacmshba5f7cd7ad1a00ep1465a3jsnf6667a29d1a5"
    )
    @GET("playlist/")
    Call<GetPlaylistResponse> getPlaylist(@Query("id") String id);

    @Headers(
            "X-RapidAPI-Key: 0ecbca7bacmshba5f7cd7ad1a00ep1465a3jsnf6667a29d1a5"
    )
    @GET("artist_overview/")
    Call<AlbumIdOfArtistModel> getArtistOverview(@Query("id") String id);

    @GET("search/")
    Call<GetSearchResponse> getSearchResult(@Query("q") String id,@Query("type") String type);

}
