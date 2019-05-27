package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Busqueda extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Donaciones:
                    Intent intent = new Intent(Busqueda.this, Donaciones.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_Busqueda:
                    Intent intent1 = new Intent(Busqueda.this, Busqueda.class);
                    startActivity(intent1);
                    overridePendingTransition(0, 0);
                    //mTextMessage.setText("Buscar");
                    return true;
                case R.id.navigation_Cuenta:
                    //mTextMessage.setText("Cuenta");
                    Intent intent2 = new Intent(Busqueda.this, Cuenta.class);
                    startActivity(intent2);
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
            //negativo
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    public void verRifa(View view){
        Intent next = new Intent(this, Rifa.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    public void categoria_libros(View view){
        Intent next = new Intent(this, CategoriaLibros.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
    public void categoria_ropa(View view){
        Intent next = new Intent(this, CategoriaRopa.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
    public void categoria_utiles(View view){
        Intent next = new Intent(this, CategoriaUtiles.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
    public void categoria_laboratorio(View view){
        Intent next = new Intent(this, CategoriaLaboratorio.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
    public void categoria_aparatos(View view){
        Intent next = new Intent(this, CategoriaAparatos.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    public void categoria_campus(View view){
        Intent next = new Intent(this, CategoriaCampus.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    public void categoria_solicitudes_pendientes(View view){
        Intent next = new Intent(this, CategoriaSolicitudesPendientes.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    public void categoria_reciente(View view){
        Intent next = new Intent(this, CategoriaReciente.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
}