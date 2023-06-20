package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album {
    @SerializedName("name")
    private String albumName;

    @SerializedName("id")
    private String albumId;

    @SerializedName("images")
    private List<AlbumImages> imagesList;
    @SerializedName("artists")
    private List<Artist> artistsList;


    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public List<AlbumImages> getImagesList() {
        return imagesList;
    }

    public List<Artist> getArtistsList() {
        return artistsList;
    }

    public void setArtistsList(List<Artist> artistsList) {
        this.artistsList = artistsList;
    }
    public static class Artist{

        @SerializedName("id")
        private String artistId;

        @SerializedName("name")
        private String artistName;

        @SerializedName("type")
        private String type;

        @SerializedName("url")
        private String url;

        public String getArtistId() {
            return artistId;
        }

        public void setArtistId(String artistId) {
            this.artistId = artistId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


    public static class AlbumImages{

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
}




