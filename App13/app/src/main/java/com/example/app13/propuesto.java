package com.example.app13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class propuesto extends AppCompatActivity {

    private TextView tv1,tv2;
    private EditText et1;

    private SharedPreferences sp1;
    private int num,puntos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propuesto);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);

        num = (int) (Math.random()*50);
        /*String cadena = String.valueOf(num);
        Toast toast = Toast.makeText(this,cadena,Toast.LENGTH_LONG);
        toast.show();*/
        sp1 = getSharedPreferences("puntos",Context.MODE_PRIVATE);
        String puntosString = sp1.getString("puntos","");
        tv1.setText("Puntaje: "+puntosString);
        puntos = Integer.parseInt(puntosString);
    }
    public void verificar(View view){
        int numString = Integer.parseInt(et1.getText().toString());
        if (numString==num){
            Toast toast = Toast.makeText(this,"Felicidades, numero encontrado",Toast.LENGTH_LONG);
            tv2.setText("Felicidades, numero encontrado");
            sp1 = getSharedPreferences("puntos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp1.edit();
            puntos = puntos + 1;
            editor.putString("puntos",String.valueOf(puntos));
            editor.commit();
            tv1.setText("Puntaje: "+String.valueOf(puntos));
        }else{
            if (numString<num){
                Toast.makeText(this,"El numero es mayor",Toast.LENGTH_LONG);
                tv2.setText("El numero es mayor");
            }else if (numString>num){
                Toast.makeText(this,"El numero es menor",Toast.LENGTH_LONG);
                tv2.setText("El numero es menor");
            }
        }
    }
}