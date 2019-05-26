package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Rifa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rifa);
    }

    public void consultarResultados(View view){
        Intent next = new Intent(this, ConsultarResultadosRifa.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
}
