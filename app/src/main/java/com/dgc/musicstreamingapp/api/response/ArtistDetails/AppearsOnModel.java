package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppearsOnModel {
    @SerializedName("items")
    private List<ReleasesModel> items;

    public List<ReleasesModel> getItems() {
        return items;
    }

    public void setItems(List<ReleasesModel> items) {
        this.items = items;
    }
}
