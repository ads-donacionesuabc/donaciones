package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.donaciones.R;

public class Frase2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase2);
    }

    public void main(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
}
