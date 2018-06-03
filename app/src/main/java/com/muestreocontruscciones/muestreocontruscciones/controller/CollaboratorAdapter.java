package com.muestreocontruscciones.muestreocontruscciones.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.core.Collaborator;

import java.util.ArrayList;

public class CollaboratorAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Collaborator> collaborators;

    public CollaboratorAdapter(Context context, ArrayList<Collaborator> collaborators) {
        this.context = context;
        this.collaborators = collaborators;
    }

    @Override
    public int getCount() {
        return collaborators.size();
    }

    @Override
    public Object getItem(int i) {
        return collaborators.get(i);
    }

    @Override
    public long getItemId(int i) {
        return collaborators.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Collaborator collaborator = (Collaborator) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.listview_collaborator_item, null);

        TextView collaboratorName = (TextView) convertView.findViewById(R.id.name);
        TextView collaboratorAlias = (TextView) convertView.findViewById(R.id.alias);
        TextView collaboratorPosition = (TextView) convertView.findViewById(R.id.position);
        TextView collaboratorProject = (TextView) convertView.findViewById(R.id.project);

        collaboratorName.setText(collaborator.getNombre());
        collaboratorAlias.setText(collaborator.getAlias());
        collaboratorPosition.setText(collaborator.getPuesto());
        collaboratorProject.setText(collaborator.getProyecto().getNombre());

        return convertView;
    }
}
