package com.dgc.musicstreamingapp.home.album;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumModel {
    private String albumName,artistName,albumCoverURL;


    public AlbumModel(String albumName,String artistName, String albumCoverURL){
        this.albumName=albumName;
        this.artistName=artistName;
        this.albumCoverURL=albumCoverURL;
    }
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumCoverURL() {
        return albumCoverURL;
    }

    public void setAlbumCoverURL(String albumCoverURL) {
        this.albumCoverURL = albumCoverURL;
    }
}
