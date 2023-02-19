package com.example.app15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
    }
    public void grabar(View v) {
        String nomarchivo = et1.getText().toString();
        nomarchivo=nomarchivo.replace('/','-');

        String contenido = et2.getText().toString();
        try {
            File tarjeta = Environment.getExternalStorageDirectory();
            Toast.makeText(this,tarjeta.getAbsolutePath(), Toast.LENGTH_LONG).show();

            File file = new File(tarjeta.getAbsolutePath(), nomarchivo+".txt");
            //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(nomarchivo,Activity.MODE_PRIVATE));
            osw.write(contenido);
            osw.flush();
            osw.close();
            Toast.makeText(this, "Los datos fueron grabados correctamente",Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
            et2.setText(file.getName()+file.getAbsolutePath());
        } catch (IOException ioe) {
            Toast.makeText(this, "No se pudo grabar",
                    Toast.LENGTH_SHORT).show();
            et2.setText(ioe+"");
        }
    }
    public void recuperar(View v) {
        String nomarchivo = et1.getText().toString();
        File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
        try {
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String todo = "";
            while (linea != null) {
                todo = todo + linea + " ";
                linea = br.readLine();
            }
            br.close();
            archivo.close();
            et2.setText(todo);
        } catch (IOException e) {
            Toast.makeText(this, "No se pudo leer"+e,Toast.LENGTH_SHORT).show();
            et2.setText(""+e);
        }
    }


}