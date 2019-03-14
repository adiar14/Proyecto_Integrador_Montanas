package com.naturex.adiar.proyecto_integrador_montanas.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Incidencia;

import java.util.ArrayList;

public class AdapterIncidencia extends RecyclerView.Adapter{

    public class IncidenciaViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDesc;
        public ImageView ivImagenInci;

        public IncidenciaViewHolder(View itemView) {
            super(itemView);


        }
    }
}
