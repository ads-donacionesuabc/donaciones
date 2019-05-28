package com.example.donaciones;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.donaciones.utilidades.Utilidades;

public class InicioSesion extends AppCompatActivity {

    TextInputEditText usuario,contra;
    ConexionSQLiteHelper conn;
    boolean p;
    String correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        conn = new ConexionSQLiteHelper(this,"db",null,1);
        usuario = (TextInputEditText)findViewById(R.id.correo);
        contra = (TextInputEditText)findViewById(R.id.contra);

    }
    public void iniciarsesion(View view)
    {
        consulta();
    }

    public void registrate(View view){
        Intent next = new Intent(this, Registro.class);
        startActivity(next);
        overridePendingTransition(0, 0);
    }
    public void consulta(){
        SQLiteDatabase db= conn.getReadableDatabase();



        ContentValues values = new ContentValues();


        String[] parametros={usuario.getText().toString()};
        String[] campo = {Utilidades.correo};


            Cursor cursor = db.query("usuarios",campo,"correo=?",parametros,null,null,null);

            if (cursor.moveToFirst()) {
                correo=cursor.getString(0);// Valor de correo
                //correo = campo.toString();
              //  correo = campo[0];
                cursor.close();
                Intent next = new Intent(this, Donaciones.class);
                startActivity(next);
                overridePendingTransition(0, 0);
           }
            else {

            Toast.makeText(getApplicationContext(),"Usuario no identificado",Toast.LENGTH_LONG).show();}


    }

    public String getCorreo() {
        return correo;
    }
}
