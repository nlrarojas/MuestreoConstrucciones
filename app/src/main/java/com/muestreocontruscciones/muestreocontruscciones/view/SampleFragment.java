package com.muestreocontruscciones.muestreocontruscciones.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muestreocontruscciones.muestreocontruscciones.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SampleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SampleFragment extends Fragment {

    public SampleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

}
