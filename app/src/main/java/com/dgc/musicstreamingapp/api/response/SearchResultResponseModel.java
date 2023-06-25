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

        @SerializedName("artists")
        private ArtistItem artistItem;

        public String getTrackId() {
            return trackId;
        }

        public String getTrackName() {
            return trackName;
        }

        public ArtistItem getArtistItem() {
            return artistItem;
        }
    }

    public class ArtistItem {
        @SerializedName("items")
        private List<ArtistProfile> artistProfileList;

        public List<ArtistProfile> getArtistProfileList() {
            return artistProfileList;
        }
    }

    public static class ArtistProfile{
        @SerializedName("profile")
        private ArtistProfileName artistProfileName;

        public ArtistProfileName getArtistProfileName() {
            return artistProfileName;
        }
    }

    public class ArtistProfileName{
        @SerializedName("name")
        private String name;

        public String getArtistName() {
            return name;
        }
    }
}

