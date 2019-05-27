package com.example.donaciones;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.donaciones.utilidades.Utilidades;

import java.util.ArrayList;

public class AgreDonacion extends AppCompatActivity {
    TextInputEditText nombre,descripcion;
    Spinner campus,categoria;

    ArrayList<String> listaDonaciones;
    ConexionSQLiteHelper conn;
    String Ncampus;
    String Ncategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agre_donacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (TextInputEditText)findViewById(R.id.input1);

        descripcion = (TextInputEditText)findViewById(R.id.desc);
        campus = (Spinner) findViewById(R.id.spinner1);
        categoria = (Spinner) findViewById(R.id.spinner);
        conn = new ConexionSQLiteHelper(getApplicationContext(),"db",null,1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.combo_campus,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.combo_categoria,android.R.layout.simple_spinner_item);
        campus.setAdapter(adapter);
        categoria.setAdapter(adapter1);

        campus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Seleccione"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                Ncampus=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Seleccione"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                Ncategoria=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void registrarDonacion(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.nombred,nombre.getText().toString());
        values.put(Utilidades.descripcion,descripcion.getText().toString());
        values.put(Utilidades.campus,Ncampus);
        values.put(Utilidades.categoria,Ncategoria);

        Long idResult = db.insert(Utilidades.tdonacion,Utilidades.nombre,values);
        Toast.makeText(getApplicationContext(),"Nombre:"+idResult,Toast.LENGTH_SHORT).show();
        db.close();
    }
//TAMPOCO SE
    public void onClick(View view){
        registrarDonacion();
        Intent intent = new Intent(AgreDonacion.this, Busqueda.class);
        startActivity(intent);
    }

}
