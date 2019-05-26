package com.example.donaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Cuenta extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cuenta,null);
    }

    /*public void acercaDe(View view){
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
    }*/
}
