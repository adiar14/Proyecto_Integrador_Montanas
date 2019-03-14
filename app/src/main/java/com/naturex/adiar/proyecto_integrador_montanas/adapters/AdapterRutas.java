package com.naturex.adiar.proyecto_integrador_montanas.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;

import java.util.ArrayList;
public class AdapterRutas extends RecyclerView.Adapter<AdapterRutas.HolderRutas> implements View.OnClickListener {
    private ArrayList<Ruta> listaRutas;
    private View.OnClickListener listener;

    public AdapterRutas(ArrayList<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }

    @NonNull
    @Override
    public HolderRutas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_content, viewGroup, false);
        v.setOnClickListener(this);
        HolderRutas h = new HolderRutas(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRutas holder, int i) {

        holder.tvNombre.setText(listaRutas.get(i).getNombre());
        /*holder.tvLongitud.setText(String.valueOf(listaRutas.get(i).getLongitud()));
        holder.tvPendiente.setText(String.valueOf(listaRutas.get(i).getPendiente()));*/
        holder.tvSuciedad.setText(listaRutas.get(i).getNivelSuciedad());
        holder.tvDificultad.setText(listaRutas.get(i).getDificultad());
        if(i==0){
            holder.ivImagen.setImageResource(R.drawable.img4);
        }
        if(i==1){
            holder.ivImagen.setImageResource(R.drawable.img5);
        }
        if(i==2){
            holder.ivImagen.setImageResource(R.drawable.img3);
        }
        if(i==3){
            holder.ivImagen.setImageResource(R.drawable.img4);
        }
        if(i==4){
            holder.ivImagen.setImageResource(R.drawable.img5);
        }
    }

    @Override
    public int getItemCount() {
        return listaRutas.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public static class HolderRutas extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvPendiente;
        private TextView tvLongitud;
        private TextView tvDificultad;
        private TextView tvSuciedad;
        private ImageView ivImagen;

        public HolderRutas(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvDescripcionIncidenciaContent);
           /* tvPendiente = itemView.findViewById(R.id.tvPendiente);
            tvLongitud = itemView.findViewById(R.id.tvLongitud);*/
            tvDificultad = itemView.findViewById(R.id.tvDificultad);
            tvSuciedad = itemView.findViewById(R.id.tvSuciedad);
            ivImagen = itemView.findViewById(R.id.ivImagenIncidenciaContent);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
