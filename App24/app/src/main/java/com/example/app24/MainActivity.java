package com.example.app24;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button b5;
    int posicion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b5 = (Button)findViewById(R.id.button5);
        Toast.makeText(this,b5.getText().toString(),Toast.LENGTH_LONG).show();
    }
    public void destruir(){
        if (mp != null){
            mp.release();
        }
    }
    public void iniciar(View view){
        destruir();
        mp = MediaPlayer.create(this,R.raw.prueba);
        mp.start();
        String op = b5.getText().toString();
        if (op.equals("No repetir")){
            mp.setLooping(false);
        }else{
            mp.setLooping(true);
        }
    }
    public void pausar(View view){
        if (mp !=null && mp.isPlaying()){
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }
    public void continuar(View view){
        if (mp != null && mp.isPlaying()==false){
            mp.seekTo(posicion);
            mp.start();
        }
    }
    public void detener(View view){
        if (mp!=null){
            mp.stop();
            posicion=0;
        }
    }
    public void circular(View view){
        detener(null);
        String op = b5.getText().toString();
        if (op.equals("No repetir")){
            b5.setText("reproducir en forma circular");
        }else{
            b5.setText("No repetir");
        }

    }

}