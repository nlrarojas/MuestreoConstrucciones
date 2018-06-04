package com.muestreocontruscciones.muestreocontruscciones.core;

public class Analyst {
    private int id;
    private int tipo;
    private String nombre;
    private String usuario;

    public Analyst(int id, int tipo, String nombre, String usuario) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Analyst() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
