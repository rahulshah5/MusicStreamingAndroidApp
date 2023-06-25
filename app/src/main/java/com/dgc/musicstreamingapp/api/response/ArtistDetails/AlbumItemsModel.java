package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;
import com.dgc.musicstreamingapp.api.response.*;
import java.util.List;

public class AlbumItemsModel {

    @SerializedName("items")
    private List<AlbumResponseModel> albumResponseModelList;

    public List<AlbumResponseModel> getAlbumResponseModelList() {
        return albumResponseModelList;
    }
}
