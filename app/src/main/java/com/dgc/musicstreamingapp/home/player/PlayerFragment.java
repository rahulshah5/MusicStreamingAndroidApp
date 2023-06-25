package com.dgc.musicstreamingapp.home.player;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.dgc.musicstreamingapp.R;

import java.io.IOException;

public class PlayerFragment extends Fragment {

    private MediaPlayer mediaPlayer;
    private Button playButton, pauseButton, stopButton, muteButton;

    private boolean isPlaying;
    private boolean isMuted;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_player,container,false);

        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);
        muteButton = findViewById(R.id.muteButton);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    try {
                        mediaPlayer.setDataSource("YOUR_AUDIO_URL_HERE");
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        isPlaying = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    mediaPlayer.pause();
                    isPlaying = false;
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    mediaPlayer.stop();
                    isPlaying = false;
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        muteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isMuted) {
                    mediaPlayer.setVolume(0, 0);
                    isMuted = true;
                } else {
                    mediaPlayer.setVolume(1, 1);
                    isMuted = false;
                }
            }
        });

        return view;
    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
