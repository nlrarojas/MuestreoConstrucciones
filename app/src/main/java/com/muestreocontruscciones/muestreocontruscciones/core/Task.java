package com.muestreocontruscciones.muestreocontruscciones.core;

public class Task {
    private int id;
    private String nombre;
    private String tipoActividad;
    private String descripcion;

    public Task(int id, String nombre, String tipoActividad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
    }

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
