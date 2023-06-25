package com.dgc.musicstreamingapp.player;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.dgc.musicstreamingapp.R;

import java.io.IOException;

public class PlayerFragment extends Fragment {

    private MediaPlayer mediaPlayer;
    private ImageButton playPauseButton, stopButton, muteButton;
    private TextView songNameTextView,trackDurationTextView,currentTime;
    private boolean isPlaying;
    private boolean isMuted;
    public static String trackUrl,trackName,trackArtistName;
    private SeekBar seekbar;
    public static int trackDuration;

    private int playedTime=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_player,container,false);

        playPauseButton = view.findViewById(R.id.play_pause_button);
        stopButton = view.findViewById(R.id.stop_button);
        muteButton = view.findViewById(R.id.mute_button);
        seekbar=view.findViewById(R.id.playerPageSeekBar);
        trackDurationTextView=view.findViewById(R.id.playerPageDuration);
        songNameTextView =view.findViewById(R.id.playerPageSongName);
        currentTime=view.findViewById(R.id.current_time);


        Handler handler=new Handler();

        songNameTextView.setText(trackName);
        Runnable updateSeekBarRunnable = new Runnable() {
            int elapsedSeconds = 0;
            @Override
            public void run() {
                int progress = seekbar.getProgress();
                // Increase the progress by the desired amount (e.g., 1)
                seekbar.setProgress(progress + 1);
                // Schedule the next update after 1 second
                elapsedSeconds++; // Increment elapsed seconds
                playedTime+=1;
                currentTime.setText(String.valueOf(playedTime));

                if (elapsedSeconds < 30) {
                    handler.postDelayed(this, 1000);
                }
            }
        };

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.reset();
        try{
            System.out.println(trackUrl);
            mediaPlayer.setDataSource(trackUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
            isPlaying = true;
            handler.post(updateSeekBarRunnable);
        }catch (IOException e) {
            e.printStackTrace();
        }



        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    mediaPlayer.start();
                    playPauseButton.setImageResource(R.drawable.icon_pause);
                    handler.post(updateSeekBarRunnable);
                    isPlaying = true;
                }else{
                    playPauseButton.setImageResource(R.drawable.icon_play);
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
                    playPauseButton.setImageResource(R.drawable.icon_play);
                    seekbar.setProgress(0);
                    currentTime.setText("0");
                    playedTime=0;
                    handler.removeCallbacks(updateSeekBarRunnable);

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
                    muteButton.setImageResource(R.drawable.icon_mute);
                } else {
                    mediaPlayer.setVolume(1, 1);
                    isMuted = false;
                    muteButton.setImageResource(R.drawable.icon_volume);
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
