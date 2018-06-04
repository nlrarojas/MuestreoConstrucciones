package com.muestreocontruscciones.muestreocontruscciones.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.core.Analyst;

import java.util.ArrayList;

public class AnalystAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Analyst> analysts;

    public AnalystAdapter(Context context, ArrayList<Analyst> analysts) {
        this.context = context;
        this.analysts = analysts;
    }

    @Override
    public int getCount() {
        return analysts.size();
    }

    @Override
    public Object getItem(int i) {
        return analysts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return analysts.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Analyst analyst = (Analyst) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.list_analyst_item, null);

        TextView analystName = (TextView) convertView.findViewById(R.id.nombreAnalista);
        TextView analystUserName = (TextView) convertView.findViewById(R.id.usuarioAnalista);

        analystName.setText(analyst.getNombre());
        analystUserName.setText(analyst.getUsuario());

        return convertView;
    }
}
