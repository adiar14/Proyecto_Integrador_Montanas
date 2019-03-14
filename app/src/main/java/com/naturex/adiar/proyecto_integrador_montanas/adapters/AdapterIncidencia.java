package com.naturex.adiar.proyecto_integrador_montanas.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Incidencia;

import java.util.ArrayList;
import java.util.List;

public class AdapterIncidencia extends RecyclerView.Adapter<AdapterIncidencia.IncidenciaViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<Incidencia> mInci;

    public AdapterIncidencia(ArrayList<Incidencia> datos, Context context) {
        mContext=context;
        mInci=datos;
    }


    @NonNull
    @Override
    public IncidenciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout_content, parent, false);
        v.setOnClickListener(this);
        IncidenciaViewHolder vh = new IncidenciaViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull IncidenciaViewHolder holder, int position) {
        Incidencia inci=mInci.get(position);
        holder.tvDesc.setText(inci.getDescripcion());
        Glide.with(mContext).load(inci.getImagen()).into(holder.ivImagenInci);
    }

    @Override
    public int getItemCount() {
       return mInci.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class IncidenciaViewHolder extends RecyclerView.ViewHolder{
        public TextView tvDesc;
        public ImageView ivImagenInci;

        public IncidenciaViewHolder(View itemView) {
            super(itemView);

            tvDesc = itemView.findViewById(R.id.tvDescripcionIncidenciaContent);
            ivImagenInci=itemView.findViewById(R.id.ivImagenIncidenciaContent);
        }
    }
}
