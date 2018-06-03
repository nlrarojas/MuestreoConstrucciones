package com.muestreocontruscciones.muestreocontruscciones.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.muestreocontruscciones.muestreocontruscciones.R;


@SuppressLint("ValidFragment")
public class CollaboratorFragment extends Fragment {
    ListView listView;
    @SuppressLint("ValidFragment")
    public CollaboratorFragment(Activity activity) {
        listView = (ListView) activity.findViewById(R.id.listCollaborators);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collaborator, container, false);
    }
}
