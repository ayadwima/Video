package com.example.videoass;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class VideoStreamActivity extends AppCompatActivity {


    PlayerView playerView;
    SimpleExoPlayer player;
    String videoUrl;

    private boolean playWhereReady = true;
    private int currentWindow = 0;
    private  long playpackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        playerView = findViewById(R.id.viedo_view);
        videoUrl = getIntent().getStringExtra("VideoUrl");

    }

    public void initVideo(){

        player = ExoPlayerFactory.newSimpleInstance(this);


        playerView.setPlayer(player);


        Uri uri = Uri.parse(videoUrl);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this , "exoplayer-codelab");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);

        player.setPlayWhenReady(playWhereReady);
        player.seekTo(currentWindow , playpackPosition);
        player.prepare(mediaSource , false , false);

    }


    public void playVideo(){
        if(player != null){
            playWhereReady = player.getPlayWhenReady();
            playpackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;

        }



    }


    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }


    @Override
    protected void onPause() {
        super.onPause();
        playVideo();
    }


    @Override
    protected void onStop() {
        super.onStop();
        playVideo();
    }


}
