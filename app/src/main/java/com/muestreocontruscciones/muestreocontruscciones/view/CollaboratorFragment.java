package com.muestreocontruscciones.muestreocontruscciones.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.controller.CollaboratorAdapter;
import com.muestreocontruscciones.muestreocontruscciones.core.Collaborator;
import com.muestreocontruscciones.muestreocontruscciones.core.Project;
import com.muestreocontruscciones.muestreocontruscciones.model.CollaboratorData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;


@SuppressLint("ValidFragment")
public class CollaboratorFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    private ListView listView;
    private View view;
    private CollaboratorAdapter collaboratorAdapter;
    private Activity activity;
    private CollaboratorData collaboratorData;
    private ArrayList<Collaborator> collaborators;

    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    JsonObjectRequest jsonObjectRequest;

    @SuppressLint("ValidFragment")
    public CollaboratorFragment(Activity activity) {
        this.activity = activity;
        this.collaboratorData = new CollaboratorData();
        this.collaborators = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_collaborator, container, false);
        requestQueue = Volley.newRequestQueue(getActivity());
        cargarWebService();
        return view;
    }

    public void cargarWebService() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Cargando colaboradores");
        progressDialog.show();
        String url = "http://163.178.173.144/estudiantes/webServiceDB/obtenerColaboradores.php";
        url = url.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressDialog.hide();
        Toast.makeText(activity, "No se pudo recuperar la información ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        progressDialog.hide();

        JSONArray jsonArray = response.optJSONArray("Colaboradores");
        JSONObject jsonObject = null;

        for (int i = 0; i < jsonArray.length(); i++){
            Collaborator collaborator = new Collaborator();
            Log.i("i", i + "");
            try {
                jsonObject = jsonArray.getJSONObject(i);
                collaborator.setNombre(jsonObject.optString("Nombre"));
                collaborator.setAlias(jsonObject.optString("Alias"));
                collaborator.setDescripcion(jsonObject.optString("Descripcion"));
                collaborator.setId((Integer.parseInt(jsonObject.optString("Id"))));
                collaborator.setPuesto(jsonObject.optString("Puesto"));
                collaborator.setProyecto(new Project(Integer.parseInt(jsonObject.optString("Id_Proyecto")), "",
                        "","","","",""));
                collaborators.add(collaborator);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        listView = (ListView) view.findViewById(R.id.list_collaborators);
        collaboratorAdapter = new CollaboratorAdapter(activity, collaborators);
        listView.setAdapter(collaboratorAdapter);
    }
}
