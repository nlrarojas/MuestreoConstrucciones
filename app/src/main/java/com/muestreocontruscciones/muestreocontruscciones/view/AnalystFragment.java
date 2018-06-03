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
 * Activities that contain this fragment must implement the
 * {@link AnalystFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnalystFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnalystFragment extends Fragment {
    public AnalystFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analyst, container, false);
    }
}
