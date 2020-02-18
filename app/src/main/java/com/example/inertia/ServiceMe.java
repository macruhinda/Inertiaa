package com.example.inertia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceMe extends AppCompatActivity {
    MediaPlayer playMedia;
Button player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_me);
        player = findViewById(R.id.playbtn);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMedia= MediaPlayer.create(getApplicationContext(),R.raw.inertiasong);
                playMedia.start();
            }
        });
    }
}
