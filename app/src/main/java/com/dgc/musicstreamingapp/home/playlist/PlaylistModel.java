package com.dgc.musicstreamingapp.home.playlist;

public class PlaylistModel {

    private String playlistName, playlistUrl;

    public PlaylistModel(String playlistName, String playlistUrl) {
        this.playlistName = playlistName;
        this.playlistUrl = playlistUrl;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistUrl() {
        return playlistUrl;
    }
}
