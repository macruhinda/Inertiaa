package com.example.inertia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceMe extends AppCompatActivity {
    MediaPlayer playMedia;
Button player,player1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_me);
        player = findViewById(R.id.playbtn);
        player1 = findViewById(R.id.pausebtn);
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playMedia != null && playMedia.isPlaying()) {
                playMedia.stop();}           
            }
        });
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMedia= MediaPlayer.create(getApplicationContext(),R.raw.inertiasong);
                playMedia.start();

            }
        });
    }
}
