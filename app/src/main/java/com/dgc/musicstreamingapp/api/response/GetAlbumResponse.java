package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAlbumResponse {

    @SerializedName("albums")
    private List<Album> albumList;

    public GetAlbumResponse(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Album> getAlbumsList() {
        return albumList;
    }

    public void setAlbumsList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
