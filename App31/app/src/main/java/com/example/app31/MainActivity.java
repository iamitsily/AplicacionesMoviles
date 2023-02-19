package com.example.app31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
    }

    class Lienzo extends View {
        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(255, 255, 0);
            int ancho = canvas.getWidth();
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
            pincel1.setStrokeWidth(4);
            canvas.drawLine(100,0,100,5000,pincel1);
            pincel1.setARGB(255,0,255,255);
            canvas.drawLine(0,100,1500,100,pincel1);
            canvas.drawLine(0,200,1500,200,pincel1);
            canvas.drawLine(0,300,1500,300,pincel1);
            canvas.drawLine(0,400,1500,400,pincel1);
            canvas.drawLine(0,500,1500,500,pincel1);
            canvas.drawLine(0,600,1500,600,pincel1);
            canvas.drawLine(0,700,1500,700,pincel1);
            canvas.drawLine(0,800,1500,800,pincel1);
            canvas.drawLine(0,900,1500,900,pincel1);
            canvas.drawLine(0,1000,1500,1000,pincel1);
            canvas.drawLine(0,1100,1500,1100,pincel1);
            canvas.drawLine(0,1200,1500,1200,pincel1);
            canvas.drawLine(0,1300,1500,1300,pincel1);
            canvas.drawLine(0,1400,1500,1400,pincel1);
            canvas.drawLine(0,1500,1500,1500,pincel1);
            canvas.drawLine(0,1600,1500,1600,pincel1);
            canvas.drawLine(0,1700,1500,1700,pincel1);
            canvas.drawLine(0,1800,1500,1800,pincel1);
            canvas.drawLine(0,1900,1500,1900,pincel1);
            canvas.drawLine(0,2000,1500,2000,pincel1);
            canvas.drawLine(0,2100,1500,2100,pincel1);
            canvas.drawLine(0,2200,1500,2200,pincel1);
            canvas.drawLine(0,2300,1500,2300,pincel1);
            canvas.drawLine(0,2400,1500,2400,pincel1);
            canvas.drawLine(0,2500,1500,2500,pincel1);
            canvas.drawLine(0,2600,1500,2600,pincel1);


        }

    }
}