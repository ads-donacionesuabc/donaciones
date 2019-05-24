package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Cuenta extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Donaciones:
                    Intent intent = new Intent(Cuenta.this, Donaciones.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_Buscar:
                    Intent intent1 = new Intent(Cuenta.this, Busqueda.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_Cuenta:
                    Intent intent2 = new Intent(Cuenta.this, Cuenta.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    public void acercaDe(View view){
        Intent next = new Intent(this, AcercaDe.class);
        startActivity(next);
    }

    public void preguntas(View view){
        Intent next = new Intent(this, Preguntas.class);
        startActivity(next);
    }

    public void sugerencias(View view){
        Intent next = new Intent(this, Sugerencias.class);
        startActivity(next);
    }
}
