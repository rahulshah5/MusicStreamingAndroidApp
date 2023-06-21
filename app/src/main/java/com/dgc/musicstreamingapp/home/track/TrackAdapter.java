package com.dgc.musicstreamingapp.home.track;

import android.media.Image;
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

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    private ArrayList<TrackModel> trackModelArrayList;

    public TrackAdapter(ArrayList<TrackModel> trackModelArrayList) {
        this.trackModelArrayList = trackModelArrayList;
    }

    @NonNull
    @Override
    public TrackAdapter.TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.track_item_list,parent,false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.TrackViewHolder holder, int position) {
        TrackModel trackModel=trackModelArrayList.get(position);
        holder.trackName.setText(trackModel.getTrackName());
        holder.trackArtistName.setText(trackModel.getTrackArtistName());
        Picasso.get().load(trackModel.getTrackImageUrl()).into(holder.trackImageUrl);
    }

    @Override
    public int getItemCount() {
        return trackModelArrayList.size();
    }
    public class TrackViewHolder extends RecyclerView.ViewHolder{

        private TextView trackName,trackArtistName;
        private ImageView trackImageUrl;
        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            trackName=itemView.findViewById(R.id.trackNameTrackItemText);
            trackArtistName=itemView.findViewById(R.id.artistNameTrackItemText);
            trackImageUrl=itemView.findViewById(R.id.trackImageTrackItemImage);
        }
    }
}
