package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

public class Images {
    public String getImageUrl() {
        return imageUrl;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @SerializedName("url")
    private String imageUrl;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;
}
