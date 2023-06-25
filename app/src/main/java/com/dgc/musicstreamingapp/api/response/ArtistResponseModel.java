package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistResponseModel {

    @SerializedName("id")
    private String artistId;
    @SerializedName("name")
    private String artistName;
    @SerializedName("images")
    private List<ImagesResponseModel> artistImagesList;

    @SerializedName("popularity")
    private int popularityRank;

    @SerializedName("genres")
    private List<String> genres;

    public int getPopularityRank() {
        return popularityRank;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getArtistId() {
        return artistId;
    }

    public List<ImagesResponseModel> getArtistImagesList() {
        return artistImagesList;
    }
    public String getArtistName() {
        return artistName;
    }
}
