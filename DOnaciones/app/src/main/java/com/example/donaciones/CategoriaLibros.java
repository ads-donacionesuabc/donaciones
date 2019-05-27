package com.example.donaciones;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.donaciones.entidades.Donacion;
import com.example.donaciones.utilidades.Utilidades;

import java.util.ArrayList;

public class CategoriaLibros extends AppCompatActivity {
    ListView list;
    ArrayList<String> listaInformacion;
    ArrayList<Donacion> listaDonaciones;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_libros);
        conn = new ConexionSQLiteHelper(getApplicationContext(),"db",null,1);

        list = (ListView) findViewById(R.id.listViewDonas);
        consultaLibros();
        ArrayAdapter adaptador =new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        list.setAdapter(adaptador);
    }
    private void consultaLibros(){
        SQLiteDatabase db= conn.getReadableDatabase();
        Donacion libro=null;
        listaDonaciones= new ArrayList<Donacion>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.tdonacion,null);

        while(cursor.moveToNext()){
            libro=new Donacion();
            libro.setNombred(cursor.getString(0));
            libro.setCategoria(cursor.getString(1));
            libro.setDescripcion(cursor.getString(2));
            libro.setCampus(cursor.getString(3));

            listaDonaciones.add(libro);
        }
        obtenerLista();

    }

    private void obtenerLista(){
        listaInformacion=new ArrayList<String>();
        //listaDonaciones.add()
        for(int i=0; i<listaDonaciones.size(); i++){
            listaInformacion.add(listaDonaciones.get(i).getDescripcion()+" - "
                    + listaDonaciones.get(i).getNombred()+" - "+listaDonaciones.get(i).getCategoria());
        }
    }

}
