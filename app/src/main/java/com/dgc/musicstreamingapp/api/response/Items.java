package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {
    @SerializedName("items")
    private List<TrackResponseModel> tracksModel;

    public List<TrackResponseModel> getTracksModel() {
        return tracksModel;
    }
}
