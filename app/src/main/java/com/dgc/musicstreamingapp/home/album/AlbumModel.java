package com.dgc.musicstreamingapp.home.album;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlbumModel {
    private String albumName,albumCoverURL,albumId;
    private String artistNames;

    public String getAlbumId() {
        return albumId;
    }

    public String getArtistNames() {
        return artistNames;
    }

    public AlbumModel(String albumName, String albumCoverURL, String artistNames) {
        this.albumName = albumName;
        this.albumCoverURL = albumCoverURL;
        this.artistNames = artistNames;
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
