package com.muestreocontruscciones.muestreocontruscciones.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
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
import com.muestreocontruscciones.muestreocontruscciones.controller.AnalystAdapter;
import com.muestreocontruscciones.muestreocontruscciones.core.Analyst;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class AnalystFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    private ListView listView;
    private View view;
    private AnalystAdapter analystAdapter;
    private Activity activity;
    private ArrayList<Analyst> analysts;

    private ProgressDialog progressDialog;
    private RequestQueue requestQueue;

    private JsonObjectRequest jsonObjectRequest;

    @SuppressLint("ValidFragment")
    public AnalystFragment(Activity activity) {
        this.activity = activity;
        this.analysts = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_analyst, container, false);
        requestQueue = Volley.newRequestQueue(getActivity());
        cargarWebService();
        return view;
    }

    public void cargarWebService() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Cargando analistas");
        progressDialog.show();
        String url = "http://163.178.173.144/estudiantes/webServiceDB/obtenerAnalistas.php";
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

        JSONArray jsonArray = response.optJSONArray("Analistas");
        JSONObject jsonObject = null;

        for (int i = 0; i < jsonArray.length(); i++){
            Analyst analyst = new Analyst();
            try {
                jsonObject = jsonArray.getJSONObject(i);
                analyst.setNombre(jsonObject.optString("Nombre"));
                analyst.setUsuario(jsonObject.optString("Usuario"));
                analyst.setId((Integer.parseInt(jsonObject.optString("Id"))));
                analysts.add(analyst);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        listView = (ListView) view.findViewById(R.id.list_analistas);
        analystAdapter = new AnalystAdapter(activity, analysts);
        listView.setAdapter(analystAdapter);
    }
}
