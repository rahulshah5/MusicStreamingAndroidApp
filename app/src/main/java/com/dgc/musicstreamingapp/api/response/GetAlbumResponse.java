package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAlbumResponse {

    @SerializedName("albums")
    private List<AlbumResponseModel> albumList;

    public GetAlbumResponse(List<AlbumResponseModel> albumList) {
        this.albumList = albumList;
    }

    public List<AlbumResponseModel> getAlbumsList() {
        return albumList;
    }

}
