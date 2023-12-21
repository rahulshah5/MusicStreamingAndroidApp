package com.dgc.musicstreamingapp.api.helper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import com.dgc.musicstreamingapp.api.response.*;
import com.dgc.musicstreamingapp.api.response.ArtistDetails.AlbumIdOfArtistModel;

public interface ApiClient {

    @Headers(
            "X-RapidAPI-Key: 5381811256mshde35faad4eb3fbep18bd35jsn1fab1077ce16"
    )
    @GET("albums/")
    Call<GetAlbumResponse>  getAlbums(@Query("ids") String ids);


    @Headers(
            "X-RapidAPI-Key: 5381811256mshde35faad4eb3fbep18bd35jsn1fab1077ce16"
    )
    @GET("tracks/")
    Call<GetTrackResponse> getTracks(@Query("ids") String ids);

    @Headers(
            "X-RapidAPI-Key: 5381811256mshde35faad4eb3fbep18bd35jsn1fab1077ce16"
    )
    @GET("artists/")
    Call<GetArtistResponse> getArtists(@Query("ids") String ids);


    @Headers(
            "X-RapidAPI-Key: 5381811256mshde35faad4eb3fbep18bd35jsn1fab1077ce16"
    )
    @GET("playlist/")
    Call<GetPlaylistResponse> getPlaylist(@Query("id") String id);

    @Headers(
            "X-RapidAPI-Key: 5381811256mshde35faad4eb3fbep18bd35jsn1fab1077ce16"
    )
    @GET("artist_overview/")
    Call<AlbumIdOfArtistModel> getArtistOverview(@Query("id") String id);

    @Headers(
            "X-RapidAPI-Key: 5381811256mshde35faad4eb3fbep18bd35jsn1fab1077ce16"
    )
    @GET("search/")
    Call<GetSearchResponse> getSearchResult(@Query("q") String id,@Query("type") String type,
                                            @Query("offset") String offset, @Query("limit") String limi,
                                            @Query("numberOfTopResults") String topResults);

}
