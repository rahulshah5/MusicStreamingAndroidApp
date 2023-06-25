package com.dgc.musicstreamingapp.home.artistdetails;

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

import com.dgc.musicstreamingapp.R;
import com.dgc.musicstreamingapp.api.helper.APIHelper;
import com.dgc.musicstreamingapp.api.helper.ApiClient;
import com.dgc.musicstreamingapp.api.response.ArtistDetails.*;
import com.dgc.musicstreamingapp.home.album.AlbumAdapter;
import com.dgc.musicstreamingapp.home.album.AlbumModel;
import com.dgc.musicstreamingapp.home.artists.*;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArtistPageAdapter extends RecyclerView.Adapter<ArtistPageAdapter.ArtistViewHolder>{

    private ArrayList<AlbumModel> albumModelArrayList;

    public ArtistPageAdapter(ArrayList<AlbumModel> albumModelsArrayList) {
        this.albumModelArrayList=albumModelsArrayList;
    }

    @NonNull
    @Override
    public ArtistPageAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item_list,parent,false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistPageAdapter.ArtistViewHolder holder, int position) {
        AlbumModel albumModel= albumModelArrayList.get(position);
        holder.albumName.setText(albumModel.getAlbumName());
        holder.albumArtistName.setText(albumModel.getArtistNames());

        for
    }

    @Override
    public int getItemCount() {
        return albumModelArrayList.size();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder{
        private ImageView albumCover;
        private TextView albumName, albumArtistName;
        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            albumCover=itemView.findViewById(R.id.albumImageView);
            albumName=itemView.findViewById(R.id.albumNameTextView);
            albumArtistName=itemView.findViewById(R.id.albumArtistName);
        }
    }
}
