package com.muestreocontruscciones.muestreocontruscciones.view;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.controller.ProjectAdapter;
import com.muestreocontruscciones.muestreocontruscciones.core.Project;
import com.muestreocontruscciones.muestreocontruscciones.util.Connection;

import java.util.Objects;

public class CreateProjectsFragment extends Fragment {

    private TextView nombre, descripcion, estado, ubicacion;
    private Button crear;


    public CreateProjectsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_projects, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        nombre = (TextView) Objects.requireNonNull(getView()).findViewById(R.id.nombre);
        descripcion = (TextView) getView().findViewById(R.id.descripcion);
        estado = (TextView) getView().findViewById(R.id.estado);
        ubicacion = (TextView) getView().findViewById(R.id.ubicacion);
        crear = (Button) getView().findViewById(R.id.button);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Snombre = nombre.getText().toString();
                String Sdescripcion = descripcion.getText().toString();
                String Sestado = estado.getText().toString();
                String Subicacion = ubicacion.getText().toString();
                boolean cancel = false;

                if(TextUtils.isEmpty(Snombre)){
                    nombre.setError(getString(R.string.error_field_required));
                    cancel = true;
                }
                if(TextUtils.isEmpty(Sdescripcion)){
                    descripcion.setError(getString(R.string.error_field_required));
                    cancel = true;
                }
                if(TextUtils.isEmpty(Sestado)){
                    estado.setError(getString(R.string.error_field_required));
                    cancel = true;
                }
                if(TextUtils.isEmpty(Subicacion)){
                    ubicacion.setError(getString(R.string.error_field_required));
                    cancel = true;
                }
                if (!cancel){
                    Project project = new Project();
                    project.setNombre(Snombre);
                    project.setDescripcion(Sdescripcion);
                    project.setEstado(Sestado);
                    project.setUbicacion(Subicacion);
                }

            }
        });

        /*
        if (mAuthTask != null) {
            return;
        }

        mEmailView.setError(null);
        mPasswordView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        }
        if (cancel) {

            focusView.requestFocus();
        } else {
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
         */



    }

}
