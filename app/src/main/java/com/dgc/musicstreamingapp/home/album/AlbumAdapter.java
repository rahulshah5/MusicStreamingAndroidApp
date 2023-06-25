package com.dgc.musicstreamingapp.home.album;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.dgc.musicstreamingapp.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dgc.musicstreamingapp.api.response.*;
import com.dgc.musicstreamingapp.R;
import com.dgc.musicstreamingapp.home.albumdetails.*;
import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private ArrayList<AlbumModel> albumModelsArrayList;
    private Context mContext;
    private GetAlbumResponse getAlbumResponse;
    public static AlbumResponseModel albumList;




    public AlbumAdapter(ArrayList<AlbumModel> albumModelsArrayList,GetAlbumResponse getAlbumResponse,Context context){
        this.albumModelsArrayList=albumModelsArrayList;
        this.getAlbumResponse=getAlbumResponse;
        this.mContext=context;
    }

    @NonNull
    @Override
    public AlbumAdapter.AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item_list,parent,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.AlbumViewHolder holder, int position) {
        int p=position;
        AlbumModel albumModel= albumModelsArrayList.get(position);
        holder.albumName.setText(albumModel.getAlbumName());
        holder.albumArtistName.setText(albumModel.getArtistNames());
        Picasso.get().load(albumModel.getAlbumCoverURL()).into(holder.albumCover);

        holder.albumCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                albumList=getAlbumResponse.getAlbumsList().get(p);
                if (mContext instanceof MainActivity){((MainActivity)mContext).onClickAlbumItem();}
            }

        });
     }



    @Override
    public int getItemCount() {
        return albumModelsArrayList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{

        private ImageView albumCover;
        private TextView albumName, albumArtistName;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumCover=itemView.findViewById(R.id.albumImageView);
            albumName=itemView.findViewById(R.id.albumNameTextView);
            albumArtistName=itemView.findViewById(R.id.albumArtistName);
        }
    }
}
