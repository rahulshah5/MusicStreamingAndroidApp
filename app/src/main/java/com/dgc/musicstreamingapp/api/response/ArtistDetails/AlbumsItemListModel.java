package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;

public class AlbumsItemListModel {
    @SerializedName("id")
    private String albumId;

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String id) {
        this.albumId = id;
    }
}
