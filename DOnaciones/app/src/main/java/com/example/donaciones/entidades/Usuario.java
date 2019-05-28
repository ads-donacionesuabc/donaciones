package com.example.donaciones.entidades;

public class Usuario {
    private String nombre;
    private String matricula;
    private String correo;
    private String telefono;
    private String contrasena;
    private String contrasena1;

    public Usuario(String nombre, String matricula, String correo, String telefono, String contrasena, String contrasena1) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.contrasena1 = contrasena1;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena1() {
        return contrasena1;
    }

    public void setContrasena1(String contrasena1) {
        this.contrasena1 = contrasena1;
    }
}
