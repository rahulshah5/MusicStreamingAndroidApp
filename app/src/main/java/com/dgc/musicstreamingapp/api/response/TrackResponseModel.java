package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackResponseModel {

    @SerializedName("id")
    private String trackid;

    @SerializedName("name")
    private String trackName;

    @SerializedName("preview_url")
    private String trackUrl;



    public String getTrackUrl() {
        return trackUrl;
    }

    public String getTrackid() {
        return trackid;
    }

    public String getTrackName() {
        return trackName;
    }




}
