package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegistroExitoso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroexitoso);
    }
    public void continuar(View view){
        Intent next = new Intent(this, Donaciones.class);
        startActivity(next);
    }
}
