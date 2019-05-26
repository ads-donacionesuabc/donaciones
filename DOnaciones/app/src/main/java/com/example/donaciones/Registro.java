package com.example.donaciones;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.donaciones.utilidades.Utilidades;

public class Registro extends AppCompatActivity {

    TextInputEditText input1,input2,input3,input4;
    EditText edi,edi1;
    Button bt;
    //inputText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edi = (EditText)findViewById(R.id.edi);
        edi1 = (EditText)findViewById(R.id.editText2);
        input1 = (TextInputEditText)findViewById(R.id.input1);
        input2 = (TextInputEditText)findViewById(R.id.input2);
        input3 = (TextInputEditText)findViewById(R.id.input3);
        input4 = (TextInputEditText)findViewById(R.id.input4);
        bt = (Button) findViewById(R.id.button5);

    }

    public void onClick(View view){
        registrarUsuario();
        Intent next = new Intent(this, RegistroExitoso.class);
        startActivity(next);
    }
    public void registrarUsuario(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.nombre,input1.getText().toString());
        values.put(Utilidades.correo,input2.getText().toString());
        values.put(Utilidades.telefono,input3.getText().toString());
        values.put(Utilidades.contrasena,edi.getText().toString());

        Long idResult = db.insert(Utilidades.tusuario,Utilidades.nombre,values);
        Toast.makeText(getApplicationContext(),"Nombre:"+idResult,Toast.LENGTH_SHORT).show();
    }
   // public void registrar(View view){
        //Intent next = new Intent(this, RegistroExitoso.class);
        //startActivity(next);
   // }
}
