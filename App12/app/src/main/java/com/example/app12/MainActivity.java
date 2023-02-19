package com.example.app12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    }
    public void ver(View view){
        Intent intent = new Intent(this,webview.class);
        intent.putExtra("direccion",et1.getText().toString());
        startActivity(intent);
    }
}