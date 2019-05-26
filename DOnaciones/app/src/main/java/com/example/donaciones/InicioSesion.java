package com.example.donaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

    }
    public void siguiente(View view){
        Intent next = new Intent(this, Donaciones.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    public void registrate(View view){
        Intent next = new Intent(this, Registro.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
}
