package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album {
    @SerializedName("name")
    private String albumName;

    @SerializedName("id")
    private String albumId;

    @SerializedName("images")
    private List<Images> imagesList;
    @SerializedName("artists")
    private List<Artist> artistsList;


    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public List<Images> getImagesList() {
        return imagesList;
    }

    public List<Artist> getArtistsList() {
        return artistsList;
    }


}




