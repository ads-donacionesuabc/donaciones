package com.example.donaciones;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.donaciones.entidades.Donacion;

import java.util.ArrayList;

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
    ListView list;
    ArrayList<String> listaInformacion;
    ArrayList<Donacion> listaDonaciones;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donaciones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        conn = new ConexionSQLiteHelper(getApplicationContext(),"db",null,1);

        list = (ListView) findViewById(R.id.listViewDonas);
        consultaLibros();
        Donaciones.CustomAdapter customAdapter = new Donaciones.CustomAdapter();

        list.setAdapter(customAdapter);
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

    ////
    private void consultaLibros(){
        SQLiteDatabase db= conn.getReadableDatabase();
        Donacion libro=null;
        listaDonaciones= new ArrayList<Donacion>();
                                                                        //Aquí iría
        Cursor cursor=db.rawQuery("SELECT * FROM donaciones where donador ='Pepe'",null);

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
//
    class CustomAdapter extends BaseAdapter {

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
            textView_campus.setText(listaDonaciones.get(i).getCampus());

            return view;
        }
    }
    /////

}
