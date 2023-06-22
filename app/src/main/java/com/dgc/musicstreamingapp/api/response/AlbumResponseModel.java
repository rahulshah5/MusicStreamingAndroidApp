package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AlbumResponseModel {
    @SerializedName("name")
    private String albumName;

    @SerializedName("id")
    private String albumId;

    @SerializedName("images")
    private List<ImagesResponseModel> imagesList;
    @SerializedName("artists")
    private List<ArtistResponseModel> artistsList;


    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public List<ImagesResponseModel> getImagesList() {
        return imagesList;
    }

    public List<ArtistResponseModel> getArtistsList() {
        return artistsList;
    }


}




