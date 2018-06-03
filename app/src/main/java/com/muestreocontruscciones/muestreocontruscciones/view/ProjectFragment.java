package com.muestreocontruscciones.muestreocontruscciones.view;


import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muestreocontruscciones.muestreocontruscciones.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment {


    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }
}
