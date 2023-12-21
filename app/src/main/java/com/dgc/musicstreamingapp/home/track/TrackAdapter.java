package com.dgc.musicstreamingapp.home.track;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dgc.musicstreamingapp.MainActivity;
import com.dgc.musicstreamingapp.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    private ArrayList<TrackModel> trackModelArrayList;
    private Context mContext;
    public static String trackUrl,trackName;
    public static int trackDuration;

    public TrackAdapter(ArrayList<TrackModel> trackModelArrayList,Context context) {
        this.trackModelArrayList = trackModelArrayList;
        this.mContext=context;
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

        holder.trackName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trackDuration=trackModel.getDuration();
                trackUrl=trackModel.getTrackPreviewUrl();
                trackName=trackModel.getTrackName();
                if (mContext instanceof MainActivity){((MainActivity)mContext).onClickTrackItem();}

            }
        });
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
            trackName=itemView.findViewById(R.id.trackItemListTrackName);
            trackArtistName=itemView.findViewById(R.id.trackItemListArtistName);
            trackImageUrl=itemView.findViewById(R.id.trackImageTrackItemImage);
        }
    }
}
