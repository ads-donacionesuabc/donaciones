package com.example.donaciones;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
        CustomAdapter customAdapter = new CustomAdapter();

        list.setAdapter(customAdapter);

        /*ArrayAdapter adaptador =new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        //list.setAdapter(adaptador);*/
    }
    private void consultaLibros(){
        SQLiteDatabase db= conn.getReadableDatabase();
        Donacion libro=null;
        listaDonaciones= new ArrayList<Donacion>();
        Cursor cursor=db.rawQuery("SELECT * FROM donaciones where categoria ='Libros'",null);

        while(cursor.moveToNext()){
            libro=new Donacion();
            libro.setNombred(cursor.getString(0));
            libro.setCategoria(cursor.getString(1));
            libro.setDescripcion(cursor.getString(2));
            libro.setCampus(cursor.getString(3));
            libro.setDonador(cursor.getString(4));

            listaDonaciones.add(libro);
        }
        obtenerLista();

    }

    private void obtenerLista(){
        listaInformacion=new ArrayList<String>();
        //listaDonaciones.add()
        for(int i=0; i<listaDonaciones.size(); i++){
            listaInformacion.add(listaDonaciones.get(i).getDonador()+" - "
                    + listaDonaciones.get(i).getNombred()+" - "+listaDonaciones.get(i).getCategoria());
        }
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return listaDonaciones.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imgView_categoria_libros);
            TextView textView_articulo = (TextView)view.findViewById(R.id.textView_articulo);
            TextView textView_campus = (TextView)view.findViewById(R.id.textView_campusuabc);

            //imageView.setImageResource(imagenes[i]);
            textView_articulo.setText(listaDonaciones.get(i).getNombred());
           // textView_campus.setText(listaDonaciones.get(i).getCampus());
            textView_campus.setText(listaDonaciones.get(i).getDonador());

            return view;
        }
    }

}
