package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;
import com.dgc.musicstreamingapp.api.response.*;

import java.util.List;

public class Track {

    @SerializedName("id")
    private String trackid;

    @SerializedName("name")
    private String trackName;

    public void setTrackid(String trackid) {
        this.trackid = trackid;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    @SerializedName("preview_url")
    private String trackUrl;

    @SerializedName("album")
    private List<Album> albumList;

    @SerializedName("artists")
    private List<Artist>  artistList;

    public String getTrackid() {
        return trackid;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }
}
