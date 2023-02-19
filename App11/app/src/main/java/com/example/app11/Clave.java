package com.example.app11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Clave extends AppCompatActivity {
    private EditText etp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clave);

        etp1 = (EditText) findViewById(R.id.etp1);
    }
    public void verificar(View view){
        if (etp1.getText().toString().equals("armas123")){
            Intent intent = new Intent(this,Welcome.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this,"Verifique la contraseña",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}