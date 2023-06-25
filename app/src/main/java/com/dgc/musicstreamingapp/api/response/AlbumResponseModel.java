package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AlbumResponseModel {
    @SerializedName("name")
    private String albumName;

    @SerializedName("id")
    private String albumId;

    @SerializedName("label")
    private String albumLabel;

    @SerializedName("total_track")
    private int totalTracks;

    @SerializedName("popularity")
    private int albumPopularity;

    @SerializedName("images")
    private List<ImagesResponseModel> imagesList;
    @SerializedName("artists")
    private List<ArtistResponseModel> artistsList;

    @SerializedName("tracks")
    private Items trackList;


    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public List<ImagesResponseModel> getImagesList() {
        return imagesList;
    }

    public List<ArtistResponseModel> getArtistsList() {
        return artistsList;
    }

    public Items getTrackList() {
        return trackList;
    }

    public String getAlbumLabel() {
        return albumLabel;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public int getAlbumPopularity() {
        return albumPopularity;
    }
}




