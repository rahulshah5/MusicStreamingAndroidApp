package com.dgc.musicstreamingapp.home.track;

public class TrackModel {

    private String trackName,trackArtistName,trackImageUrl,trackPreviewUrl;
    private int duration;

    public TrackModel(String trackName, String trackArtistName, String trackImageUrl, String trackPreviewUrl, int duration) {
        this.trackName = trackName;
        this.trackArtistName = trackArtistName;
        this.trackImageUrl = trackImageUrl;
        this.trackPreviewUrl = trackPreviewUrl;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getTrackPreviewUrl() {
        return trackPreviewUrl;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackArtistName() {
        return trackArtistName;
    }

    public void setTrackArtistName(String trackArtistName) {
        this.trackArtistName = trackArtistName;
    }

    public String getTrackImageUrl() {
        return trackImageUrl;
    }

    public void setTrackImageUrl(String trackImageUrl) {
        this.trackImageUrl = trackImageUrl;
    }
}
