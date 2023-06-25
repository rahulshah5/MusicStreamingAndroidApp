package com.dgc.musicstreamingapp.api.response.ArtistDetails;

import com.google.gson.annotations.SerializedName;

public class ArtistDetails {
    @SerializedName("relatedContent")
    private RelatedContentModel relatedContentModelsList;

    public RelatedContentModel getRelatedContentModelsList() {
        return relatedContentModelsList;
    }

}
