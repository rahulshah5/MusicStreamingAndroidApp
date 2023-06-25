package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;

public class ArtistsData {
    @SerializedName("artist")
    private ArtistDetails artistDetailsList;

    public ArtistDetails getArtistDetailsList() {
        return artistDetailsList;
    }
}
