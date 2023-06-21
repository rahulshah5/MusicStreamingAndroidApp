package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTrackResponse {

    @SerializedName("tracks")
    private List<TrackResponseModel> trackList;

    public GetTrackResponse(List<TrackResponseModel> trackList) {
        this.trackList = trackList;
    }

    public List<TrackResponseModel> getTrackList() {
        return trackList;
    }
}
