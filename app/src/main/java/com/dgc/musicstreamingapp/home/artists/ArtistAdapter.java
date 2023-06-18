package com.dgc.musicstreamingapp.home.artists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dgc.musicstreamingapp.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private ArrayList<ArtistModel> artistModelArrayList;

    public ArtistAdapter(ArrayList<ArtistModel> artistModelArrayList){
        this.artistModelArrayList=artistModelArrayList;
    }

    @NonNull
    @Override
    public ArtistAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_item_list,parent,false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ArtistViewHolder holder, int position) {
        ArtistModel artistModel=artistModelArrayList.get(position);
        holder.artistName.setText(artistModel.getArtistName());
        Picasso.get().load(artistModel.getArtistCoverUrl()).into(holder.artistCover);

    }

    @Override
    public int getItemCount() {
        return artistModelArrayList.size();
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder{

        private ImageView artistCover;
        private TextView artistName;

        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            artistName=itemView.findViewById(R.id.artistNameTextView);
            artistCover=itemView.findViewById(R.id.artistImageView);
        }
    }
}
