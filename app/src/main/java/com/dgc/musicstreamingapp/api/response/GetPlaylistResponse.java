package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPlaylistResponse {

    @SerializedName("name")
    private String playlistName;

    @SerializedName("images")
    private List<ImagesResponseModel> imagesList;

    public String getPlaylistName() {
        return playlistName;
    }

    public List<ImagesResponseModel> getImagesList() {
        return imagesList;
    }
}
