package com.dgc.musicstreamingapp.home.artists;

import java.util.List;

public class ArtistModel {

    private String artistName, artistCoverUrl,artistId;
    private List<String> artistGenres;
    private int popularity;

    public ArtistModel(String artistName, String artistCoverUrl, String artistId, List<String> artistGenres, int popularity) {
        this.artistName = artistName;
        this.artistCoverUrl = artistCoverUrl;
        this.artistId = artistId;
        this.artistGenres = artistGenres;
        this.popularity = popularity;
    }

    public String getArtistId() {
        return artistId;
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

    public List<String> getArtistGenres() {
        return artistGenres;
    }

    public int getPopularity() {
        return popularity;
    }
}
