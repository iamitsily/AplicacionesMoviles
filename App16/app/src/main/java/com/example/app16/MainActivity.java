package com.example.app16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }
    public void alta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",descri);
        registro.put("precio",pre);
        db.insert("articulos",null,registro);
        db.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this,"Se cargaron los datos de articulo",Toast.LENGTH_LONG).show();
        db.close();
    }
    public void consultaPorCodigo(View view){
        AdminSQLiteOpenHelper aadmin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = aadmin.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = db.rawQuery("select descripcion, precio from articulos where codigo="+cod,null);
        if (fila.moveToFirst()){
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        }else{
            Toast.makeText(this,"No existe un articulo con ese codigo",Toast.LENGTH_LONG).show();
        }
        db.close();
    }
    public void consultaPorDescripcion(View view){
        AdminSQLiteOpenHelper aadmin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = aadmin.getWritableDatabase();
        String descri = et2.getText().toString();
        Cursor fila = db.rawQuery("select codigo, precio from articulos where descripcion='"+descri+"'",null);
        if (fila.moveToFirst()){
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        }else{
            Toast.makeText(this,"No existe un articulo con esa descripcion",Toast.LENGTH_LONG).show();
        }
        db.close();
    }
    public void bajaPorCodigo(View view){
        AdminSQLiteOpenHelper aadmin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = aadmin.getWritableDatabase();
        String cod = et1.getText().toString();
        int cant  = db.delete("articulos","codigo="+cod,null);
        db.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");

        if(cant == 1){
            Toast.makeText(this,"Se elimino el articulo con dicho codigo",Toast.LENGTH_LONG).show();
        }
    }
    public void modificar(View view){
        AdminSQLiteOpenHelper aadmin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = aadmin.getWritableDatabase();
        String cod = et1.getText().toString();
        String descri = et2.getText().toString();
        String pre = et3.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",descri);
        registro.put("precio",pre);

        int cant = db.update("articulos",registro,"codigo="+cod,null);
        db.close();
        if (cant == 1){
            Toast.makeText(this,"Se modificaron los datos",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No existe un articulo con el codigo ingresado",Toast.LENGTH_LONG).show();
        }
    }
    public void limpiar(View view){
        et1.setText("");
        et2.setText("");
        et3.setText("");

    }
}