package com.example.donaciones;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    public void siguiente(View view){
        Intent next = new Intent(this, ventana2.class);
        startActivity(next);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Donaciones:
                    Intent intent = new Intent(MainActivity.this, Donaciones.class);
                    startActivity(intent);
                    mTextMessage.setText("Donaciones");
                    return true;
                case R.id.navigation_Buscar:
                    Intent intent1 = new Intent(MainActivity.this, Busqueda.class);
                    startActivity(intent1);
                    //mTextMessage.setText("Buscar");
                    return true;
                case R.id.navigation_Cuenta:
                    //mTextMessage.setText("Cuenta");
                    Intent intent2 = new Intent(MainActivity.this, Cuenta.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setBackgroundColor(Color.parseColor("#009933"));
    }



}
