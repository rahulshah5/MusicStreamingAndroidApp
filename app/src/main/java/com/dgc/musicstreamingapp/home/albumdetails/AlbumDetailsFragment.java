package com.dgc.musicstreamingapp.home.albumdetails;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dgc.musicstreamingapp.home.album.*;
import com.dgc.musicstreamingapp.api.response.*;
import com.dgc.musicstreamingapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailsFragment extends Fragment {

    private AlbumDetailsAdapter albumDetailsAdapter;
    private RecyclerView recyclerView;

    private AlbumAdapter albumAdapter;
    private List<TrackResponseModel> trackList;
    private AlbumResponseModel albumList;

    private ImageView albumCover;
    private TextView albumTitle,albumLabel,albumTrackNo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.activity_full_page,container,false);

       recyclerView=view.findViewById(R.id.albumPageTrackRecyclerView);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        albumList=albumAdapter.albumList;

        albumTitle=view.findViewById(R.id.albumPageTitleTextView);
        albumCover=view.findViewById(R.id.albumPageCoverImageView);

        albumLabel=view.findViewById(R.id.albumPageLabelTextView);

        albumTitle.setText(albumList.getAlbumName());
        albumLabel.setText(albumList.getAlbumLabel());

        Picasso.get().load(albumList.getImagesList().get(0).getImageUrl()).into(albumCover);

        trackList=new ArrayList<>();
        trackList=albumList.getTrackList().getTracksModel();
        System.out.println(albumList.getAlbumName()+" inside album detail fragment");
        albumDetailsAdapter=new AlbumDetailsAdapter(trackList,albumList);
        recyclerView.setAdapter(albumDetailsAdapter);

        return view;
    }
}
