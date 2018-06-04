package com.muestreocontruscciones.muestreocontruscciones.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.controller.ProjectAdapter;
import com.muestreocontruscciones.muestreocontruscciones.core.Project;
import com.muestreocontruscciones.muestreocontruscciones.util.Connection;

import org.w3c.dom.ls.LSInput;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressLint("ValidFragment")
public class ProjectFragment extends Fragment {

    private Activity activity;
    private ListView listaProject;
    private ArrayList<Project> projects;
    private Connection connection;
    private Button crear;


    @SuppressLint("ValidFragment")
    public ProjectFragment(Activity activity) {
        this.activity = activity;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        listaProject = Objects.requireNonNull(getView()).findViewById(R.id.listProjects);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        connection = new Connection();
        projects = connection.GetProjects();

        ProjectAdapter adapter = new ProjectAdapter(activity,projects);
        listaProject.setAdapter(adapter);

        crear = getView().findViewById(R.id.button);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CreateProjectsFragment()).commit();
            }
        });


    }
}
