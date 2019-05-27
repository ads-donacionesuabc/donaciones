package com.example.donaciones.entidades;

import android.media.Image;

import java.io.Serializable;

public class Donacion implements Serializable {

    private String nombred;
    private String campus;
    private String categoria;
    private String descripcion;
    //private Image
    public Donacion(String nombred, String campus, String categoria, String descripcion) {
        this.nombred = nombred;
        this.campus = campus;
        this.categoria = categoria;
        this.descripcion = descripcion;

    }

    public Donacion() {

    }
//NO SE DAFADFADF

    public String getNombred() {
        return nombred;
    }

    public void setNombred(String nombred) {
        this.nombred = nombred;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

