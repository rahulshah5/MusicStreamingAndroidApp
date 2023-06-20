package com.dgc.musicstreamingapp.home.artists;

public class ArtistModel {

    private String artistName, artistCoverUrl;

    public ArtistModel(String artistName,String artistCover){
        this.artistCoverUrl =artistCover;
        this.artistName=artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistCoverUrl() {
        return artistCoverUrl;
    }

    public void setArtistCoverUrl(String artistCoverUrl) {
        this.artistCoverUrl = artistCoverUrl;
    }
}
