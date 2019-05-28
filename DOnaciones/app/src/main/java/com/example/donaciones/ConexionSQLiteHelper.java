package com.example.donaciones;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.donaciones.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //Metodo crea tablas
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.TABLA_USUARIO);
        db.execSQL(Utilidades.TABLA_DONACION);
    }
    //Metodo verifica si ya hay version antigua de base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //db.execSQL("drop table if exists usuarios ");
    onCreate(db);
    }
}
