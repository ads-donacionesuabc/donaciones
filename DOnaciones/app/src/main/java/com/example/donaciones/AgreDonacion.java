package com.example.donaciones;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donaciones.utilidades.Utilidades;

import java.util.ArrayList;

public class AgreDonacion extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText nombre,descripcion;
    Spinner campus,categoria;

    ArrayList<String> listaDonaciones;
    ConexionSQLiteHelper conn;
    String Ncampus;
    String Ncategoria;
    Button donar;
    final static int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agre_donacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (TextInputEditText)findViewById(R.id.input1);

        donar = (Button) findViewById(R.id.botonDonar);
        donar.setOnClickListener(this);

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

        Long idResult = db.insert(Utilidades.tdonacion,Utilidades.nombred,values);
        Toast.makeText(getApplicationContext(),"Nombre:"+idResult,Toast.LENGTH_SHORT).show();
        db.close();
    }

    /*******************************************************************************************
     *******************************************************************************************
     *******************************************************************************************
     *******************************************************************************************/
    public void selecFoto(View view){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView nFoto = (TextView) findViewById(R.id.nombre_foto);
        if((resultCode == PICK_IMAGE || resultCode == RESULT_OK) && data != null){
            Uri seleccion = data.getData();
            //getPath regresa la direccion de la imagen que se selecciono.
            nFoto.setText(seleccion.getPath());
        }
        else{
            nFoto.setText("No funciono.");
        }

    }


    public void cambio(View view){
        registrarDonacion();
        Intent intent = new Intent(AgreDonacion.this, Busqueda.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botonDonar){
            Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galeria, PICK_IMAGE);
        }
    }


}
