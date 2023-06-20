package com.dgc.musicstreamingapp.home.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.R;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private ArrayList<AlbumModel> albumModelsArrayList;

    public AlbumAdapter(ArrayList<AlbumModel> albumModelsArrayList){
        this.albumModelsArrayList=albumModelsArrayList;
    }

    @NonNull
    @Override
    public AlbumAdapter.AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item_list,parent,false);

        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.AlbumViewHolder holder, int position) {

        AlbumModel albumModel= albumModelsArrayList.get(position);
        holder.albumName.setText(albumModel.getAlbumName());
        Picasso.get().load(albumModel.getAlbumCoverURL()).into(holder.albumCover);

     }

    @Override
    public int getItemCount() {
        return albumModelsArrayList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        private ImageView albumCover;
        private TextView albumName;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumCover=itemView.findViewById(R.id.albumImageView);
            albumName=itemView.findViewById(R.id.albumNameTextView);
        }
    }
}
