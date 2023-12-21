package com.dgc.musicstreamingapp.api.response;

import com.google.gson.annotations.SerializedName;

public class GetSearchResponse {

    @SerializedName("tracks")
    private SearchResultResponseModel searchResultResponseModel;

    public SearchResultResponseModel getSearchResultResponseModel() {
        return searchResultResponseModel;
    }
}
