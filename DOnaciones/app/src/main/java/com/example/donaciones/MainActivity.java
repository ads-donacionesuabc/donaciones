package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    public void siguiente(View view) {
        Intent next = new Intent(this, InicioSesion.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd",null,1);
    }

    public void frase1(View view){
        Intent next = new Intent(this, Frase1.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

    public void frase2(View view){
        Intent next = new Intent(this, Frase2.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }

}
