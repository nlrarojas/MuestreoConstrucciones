package com.muestreocontruscciones.muestreocontruscciones.core;
import java.sql.Time;
import java.util.Date;

public class Horarios {
    private int id;
    private Date hora;
    private Time duracion;
    private String descripcion;
    private Project proyecto;

    public Horarios(int id, Date hora, Time duracion, String descripcion, Project proyecto) {
        this.id = id;
        this.hora = hora;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.proyecto = proyecto;
    }

    public Horarios() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Time getDuracion() { return duracion; }

    public void setDuracion(Time duracion) { this.duracion = duracion; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Project getProyecto() {
        return proyecto;
    }

    public void setProyecto(Project proyecto) {
        this.proyecto = proyecto;
    }
}
