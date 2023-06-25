package com.dgc.musicstreamingapp.home.artists;

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
import java.util.List;


public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private ArrayList<ArtistModel> artistModelArrayList;
    private Context mContext;
    public static String artistId,artistName,artistImageUrl;
    public static int artistPopularity;
    public static List<String> artistGenres;
    public ArtistAdapter(ArrayList<ArtistModel> artistModelArrayList,Context context){
        this.artistModelArrayList=artistModelArrayList;
        this.mContext=context;
    }

    @NonNull
    @Override
    public ArtistAdapter.ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_item_list,parent,false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ArtistViewHolder holder, int position) {
        int p=position;
        ArtistModel artistModel=artistModelArrayList.get(position);
        holder.artistName.setText(artistModel.getArtistName());
        Picasso.get().load(artistModel.getArtistCoverUrl()).into(holder.artistCover);

        holder.artistCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                artistId=artistModelArrayList.get(p).getArtistId();
                artistName=artistModelArrayList.get(p).getArtistName();
                artistImageUrl=artistModelArrayList.get(p).getArtistCoverUrl();
                artistPopularity=artistModelArrayList.get(p).getPopularity();
                artistGenres=artistModelArrayList.get(p).getArtistGenres();

                if (mContext instanceof MainActivity){((MainActivity)mContext).onClickArtistItem();}
            }
        });

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
