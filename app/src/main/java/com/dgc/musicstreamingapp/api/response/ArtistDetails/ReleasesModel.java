package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ReleasesModel {

    @SerializedName("releases")
    private AlbumItemsModel albumItemsModelList;

    public AlbumItemsModel getAlbumItemsModelList() {
        return albumItemsModelList;
    }
}
