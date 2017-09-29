package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer song = MediaPlayer.create(getApplicationContext(), R.raw.naive_by_the_kooks);

        Button play = (Button) findViewById(R.id.play_button);
        Button pause = (Button) findViewById(R.id.pause_button);
        Button skipAhead = (Button) findViewById(R.id.skip_ahead_button);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (song.isPlaying()) {
                    return;
                } else {
                    song.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast done = Toast.makeText(getApplicationContext(), "I'm done!", Toast.LENGTH_SHORT);
                            done.show();f
                        }
                    });
                    song.start();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.pause();
            }
        });

        skipAhead.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                song.seekTo(195000);
            }
        });
    }
}
