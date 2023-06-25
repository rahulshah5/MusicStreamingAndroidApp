package com.dgc.musicstreamingapp.home.playlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dgc.musicstreamingapp.R;

public class PlaylistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public PlaylistAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder{

        private ImageView playlistCover;
        private TextView playlistName;

        public PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            playlistCover=itemView.findViewById(R.id.artistNameTextView);
            playlistCover=itemView.findViewById(R.id.artistImageView);
        }
    }
}
