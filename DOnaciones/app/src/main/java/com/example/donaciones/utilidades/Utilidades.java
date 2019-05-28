package com.example.donaciones.utilidades;

public class Utilidades {

    public static final String tusuario = "usuarios";
    public static final String nombre = "nombre";
    public static final String matricula = "matricula";
    public static final String correo = "correo";
    public static final String telefono = "telefono";
    public static final String contrasena = "contrasena";
    public static final String contrasena1 = "contrasena1";
    public static final String TABLA_USUARIO="create table "+tusuario+"("+matricula+" TEXT,"+nombre+" TEXT,"+ correo+" TEXT,"+telefono+" TEXT,"+contrasena+" TEXT,"+contrasena1+" TEXT)";


    public static final String tdonacion = "donaciones";
    public static final String nombred = "nombred";
    public static final String descripcion = "descripcion";
    public static final String campus = "campus";
    public static final String categoria = "categoria";
    public static final String donador = "donador";
    public static final String TABLA_DONACION="create table "+tdonacion+"("+nombred+" TEXT,"+ categoria+" TEXT,"+descripcion+" TEXT,"+campus+" TEXT,"+donador+" TEXT)";



    public static final String tsolicitud = "solicitudes";
    public static final String nombreS = "nombreS";
    public static final String TABLA_SOLICITUD="create table "+tsolicitud+"("+nombreS+" TEXT,"+nombred+" TEXT,"+nombre+" TEXT)";
}
