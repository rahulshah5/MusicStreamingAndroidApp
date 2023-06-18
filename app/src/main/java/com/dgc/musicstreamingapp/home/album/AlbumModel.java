package com.dgc.musicstreamingapp.home.album;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumModel {
    private String albumName,albumCoverURL;


    public AlbumModel(String albumName, String albumCoverURL){
        this.albumName=albumName;
        this.albumCoverURL=albumCoverURL;
    }
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }




    public String getAlbumCoverURL() {
        return albumCoverURL;
    }

    public void setAlbumCoverURL(String albumCoverURL) {
        this.albumCoverURL = albumCoverURL;
    }
}
