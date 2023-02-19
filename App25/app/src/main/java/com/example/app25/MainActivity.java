package com.example.app25;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
    }

    public void reproducir(View view){
        Uri datos=null;
        MediaPlayer mp=null;
         datos = Uri.parse(getApplicationContext().getFilesDir()+"/gato.mp3");
        Toast.makeText(this,datos+"",Toast.LENGTH_LONG).show();
        et1.setText(datos+"");
        mp = MediaPlayer.create(this,datos);

        try {
            mp.start();
        }catch (Exception e){
            et1.setText(e+""+datos);
        }
    }
}