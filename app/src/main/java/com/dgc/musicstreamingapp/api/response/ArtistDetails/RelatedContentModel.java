package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;

public class RelatedContentModel {
    @SerializedName("appearsOn")
    private AppearsOnModel appearsOn;


    public AppearsOnModel getAppearsOn() {
        return appearsOn;
    }

    public void setAppearsOn(AppearsOnModel appearsOn) {
        this.appearsOn = appearsOn;
    }
}
