package com.example.app49;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> datos;
    private ArrayAdapter<String> adaptador1;
    private ListView lv1;
    private EditText et1, et2;
    private SharedPreferences prefe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new ArrayList<String>();
        leerSharedPreferences();
        adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        lv1 = (ListView) findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion = i;
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        String s = datos.get(posicion);
                        StringTokenizer tok1 = new StringTokenizer(s, ":");
                        String nom = tok1.nextToken().trim();
                        SharedPreferences.Editor elemento = prefe1.edit();
                        elemento.remove(nom);
                        elemento.commit();
                        datos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();
                return false;
            }
        });
    }

    private void leerSharedPreferences() {
        prefe1 = getSharedPreferences("datostelefonos", Context.MODE_PRIVATE);
        Map<String, ?> claves = prefe1.getAll();
        for (Map.Entry<String, ?> ele : claves.entrySet()) {
            datos.add(ele.getKey() + " : " + ele.getValue().toString());
        }
    }

    public void agregar(View v) {
        datos.add(et1.getText().toString() + " :" + et2.getText().toString());
        adaptador1.notifyDataSetChanged();
        SharedPreferences.Editor elemento = prefe1.edit();
        elemento.putString(et1.getText().toString(), et2.getText().toString());
        elemento.commit();
        et1.setText("");
        et2.setText("");
    }
}