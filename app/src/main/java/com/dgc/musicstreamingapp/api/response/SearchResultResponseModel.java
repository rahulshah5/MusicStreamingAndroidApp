package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResultResponseModel {

    @SerializedName("items")
    private List<ArtistData> artistData;

    public List<ArtistData> getArtistData() {
        return artistData;
    }

    public static class ArtistData{
        @SerializedName("data")
        private  ArtistIdName artistIdName;

        public ArtistIdName getArtistIdName() {
            return artistIdName;
        }
    }

    public class ArtistIdName{
        @SerializedName("id")
        private String trackId;

        @SerializedName("name")
        private String trackName;

        public String getTrackId() {
            return trackId;
        }

        public String getTrackName() {
            return trackName;
        }
    }

}

