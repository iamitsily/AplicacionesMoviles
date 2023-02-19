package com.example.app26;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ejecutar(View view){
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource("https://cdn.pixabay.com/audio/2022/12/22/audio_fb4198257e.mp3");
            mp.prepare();
            mp.start();
        }catch (IOException e){
            Toast.makeText(this,e+"",Toast.LENGTH_LONG).show();
        }
    }
}