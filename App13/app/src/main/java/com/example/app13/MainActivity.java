package com.example.app13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        SharedPreferences sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(sharedPreferences.getString("mail",""));
    }
    public void ejecutar(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("mail",et1.getText().toString());
        editor.commit();
        finish();
    }
    public void problema2(View view){
        Intent intent = new Intent(this,problema2.class);
        startActivity(intent);
    }
    public void propuesto(View view){
        Intent intent = new Intent(this,propuesto.class);
        startActivity(intent);
    }
}