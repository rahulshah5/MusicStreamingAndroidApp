package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {

    @SerializedName("id")
    private String artistId;

    @SerializedName("name")
    private String artistName;



//    @SerializedName("images")
//    private List<Images> artistImagesList;



//    public List<Images> getArtistImagesList() {
//        return artistImagesList;
//    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

}
