package com.dgc.musicstreamingapp.api.response.ArtistDetails;
import java.util.List;
import com.google.gson.annotations.SerializedName;


public class AlbumIdOfArtistModel {

    @SerializedName("data")
    private ArtistsData dataList;

    public ArtistsData getDataList() {
        return dataList;
    }
}



