package com.muestreocontruscciones.muestreocontruscciones.core;

public class Collaborator {
    private int id;
    private Project proyecto;
    private String nombre;
    private String descripcion;
    private String alias;
    private String puesto;

    public Collaborator(int id, Project proyecto, String nombre, String descripcion, String alias, String puesto) {
        this.id = id;
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alias = alias;
        this.puesto = puesto;
    }

    public Collaborator() {

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlias() {
        return alias;
    }

    public Project getProyecto() {
        return proyecto;
    }

    public void setProyecto(Project proyecto) {
        this.proyecto = proyecto;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
