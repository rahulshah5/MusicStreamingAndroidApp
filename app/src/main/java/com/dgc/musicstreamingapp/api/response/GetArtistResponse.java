package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetArtistResponse {

    @SerializedName("artists")
    private List<ArtistResponseModel> artistsList;

    public GetArtistResponse(List<ArtistResponseModel> artistsList) {
        this.artistsList = artistsList;
    }

    public List<ArtistResponseModel> getArtistsList() {
        return artistsList;
    }

    public void setArtistsList(List<ArtistResponseModel> artistsList) {
        this.artistsList = artistsList;
    }
}
