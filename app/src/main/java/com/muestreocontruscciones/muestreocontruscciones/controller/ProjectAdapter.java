package com.muestreocontruscciones.muestreocontruscciones.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.core.Project;

import org.w3c.dom.Text;

import java.util.List;

public class ProjectAdapter extends BaseAdapter {

    Context contexto;
    List<Project> listaObjetos;

    public ProjectAdapter(Context contexto, List<Project> listaObjetos) {
        this.contexto = contexto;
        this.listaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return listaObjetos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaObjetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaObjetos.get(i).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Project project = (Project) getItem(i);

        view = LayoutInflater.from(contexto).inflate(R.layout.listview_project_item, null);

        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        TextView ubicacion = (TextView) view.findViewById(R.id.ubicacion);
        TextView estado = (TextView) view.findViewById(R.id.estado);
        Button modificar = (Button) view.findViewById(R.id.modificar);
        Button eliminar = (Button) view.findViewById(R.id.eliminar);

        nombre.setText(project.getNombre());
        ubicacion.setText(project.getUbicacion());
        estado.setText(project.getEstado());

        return view;
    }
}
