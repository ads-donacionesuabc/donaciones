package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Donaciones extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Donaciones:
                    Intent intent = new Intent(Donaciones.this, Donaciones.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_Busqueda:
                    Intent intent1 = new Intent(Donaciones.this, Busqueda.class);
                    startActivity(intent1);
                    overridePendingTransition(0, 0);
                    //mTextMessage.setText("Buscar");
                    return true;
                case R.id.navigation_Cuenta:
                    Intent intent2 = new Intent(Donaciones.this, Cuenta.class);
                    startActivity(intent2);
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donaciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    protected void sigLayout(View view){
        setContentView(R.layout.activity_agre_donacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void next(View view){
        Intent intent = new Intent(Donaciones.this, AgreDonacion.class);
        startActivity(intent);
    }

    public void regLayout(View view){
        setContentView(R.layout.activity_donaciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
