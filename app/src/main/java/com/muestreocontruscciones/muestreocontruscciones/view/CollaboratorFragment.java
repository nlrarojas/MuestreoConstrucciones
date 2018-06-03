package com.muestreocontruscciones.muestreocontruscciones.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.controller.CollaboratorAdapter;
import com.muestreocontruscciones.muestreocontruscciones.core.Collaborator;
import com.muestreocontruscciones.muestreocontruscciones.core.Project;
import com.muestreocontruscciones.muestreocontruscciones.model.CollaboratorData;

import java.util.ArrayList;
import java.util.Date;


@SuppressLint("ValidFragment")
public class CollaboratorFragment extends Fragment {
    private ListView listView;
    private CollaboratorAdapter collaboratorAdapter;
    private Activity activity;
    private CollaboratorData collaboratorData;

    @SuppressLint("ValidFragment")
    public CollaboratorFragment(Activity activity) {
        this.activity = activity;
        this.collaboratorData = new CollaboratorData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collaborator, container, false);
        listView = (ListView) view.findViewById(R.id.list_collaborators);
        collaboratorAdapter = new CollaboratorAdapter(activity, getCollaborators());
        listView.setAdapter(collaboratorAdapter);
        return view;
    }

    private ArrayList<Collaborator> getCollaborators() {
        return collaboratorData.getCollaborators();
    }

    public ArrayList<Collaborator> collaboratorsList () {
        ArrayList<Collaborator> collaborators = new ArrayList<>();
        collaborators.add(new Collaborator(1, new Project(1, "Centro comercial", "San José", "Centro Comercial",
                "Concluido", "2018-05-15", "2018-05-31"), "Centro Comercial", "Trabajos de albañilería",
                "Negro", "Albañil"));
        collaborators.add(new Collaborator(1, new Project(1, "Centro comercial", "San José", "Centro Comercial",
                "Concluido", "2018-05-15", "2018-05-31"), "Centro Comercial", "Trabajos de albañilería",
                "Negro", "Albañil"));
        collaborators.add(new Collaborator(1, new Project(1, "Centro comercial", "San José", "Centro Comercial",
                "Concluido", "2018-05-15", "2018-05-31"), "Centro Comercial", "Trabajos de albañilería",
                "Negro", "Albañil"));
        return collaborators;
    }
}
