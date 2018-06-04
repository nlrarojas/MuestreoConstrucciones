package com.muestreocontruscciones.muestreocontruscciones.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.muestreocontruscciones.muestreocontruscciones.R;
import com.muestreocontruscciones.muestreocontruscciones.core.Task;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Task> tasks;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tasks.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = (Task) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.list_task_item, null);

        TextView taskName = (TextView) convertView.findViewById(R.id.nameTask);
        TextView taskTipoActividad = (TextView) convertView.findViewById(R.id.tipoTarea);
        TextView taskDescripcion = (TextView) convertView.findViewById(R.id.descripcionTarea);

        taskName.setText(task.getNombre());
        taskTipoActividad.setText(task.getTipoActividad());
        taskDescripcion.setText(task.getDescripcion());

        return convertView;
    }
}

