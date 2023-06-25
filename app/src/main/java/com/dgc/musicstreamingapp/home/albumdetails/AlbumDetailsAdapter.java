package com.dgc.musicstreamingapp.home.albumdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dgc.musicstreamingapp.MainActivity;
import com.dgc.musicstreamingapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dgc.musicstreamingapp.api.response.*;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumDetailsAdapter extends RecyclerView.Adapter<AlbumDetailsAdapter.AlbumDetailViewHolder> {

    private AlbumResponseModel albumlist;
    private List<TrackResponseModel>  trackList;
    public static String trackUrl,trackName;
    public static int trackDuration;
    private Context mContext;


    public AlbumDetailsAdapter(List<TrackResponseModel>  trackList,AlbumResponseModel albumlist,Context context) {
        this.trackList=trackList;
        this.albumlist=albumlist;
        this.mContext=context;
    }

    @NonNull
    @Override
    public AlbumDetailsAdapter.AlbumDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.track_item_list,parent,false);
        return new AlbumDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumDetailsAdapter.AlbumDetailViewHolder holder, int position) {
        int pos=position;
        holder.trackArtistName.setText(albumlist.getArtistsList().get(0).getArtistName());
        holder.trackName.setText(trackList.get(pos).getTrackName());

        holder.trackName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trackDuration=trackList.get(pos).getDuration();
                trackUrl=trackList.get(pos).getTrackUrl();
                trackName=trackList.get(pos).getTrackName();
                if (mContext instanceof MainActivity){((MainActivity)mContext).onClickAlbumTrackItem();}
            }
        });
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class AlbumDetailViewHolder extends RecyclerView.ViewHolder{
        private TextView trackName,trackArtistName;

        public AlbumDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            trackName=itemView.findViewById(R.id.trackItemListTrackName);
            trackArtistName=itemView.findViewById(R.id.trackItemListArtistName);
        }
    }
}
