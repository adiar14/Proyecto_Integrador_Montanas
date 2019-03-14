package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.adapters.AdapterIncidencias;
import com.naturex.adiar.proyecto_integrador_montanas.adapters.AdapterRutas;
import com.naturex.adiar.proyecto_integrador_montanas.db.RutaDataSource;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Incidencia;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;
import com.naturex.adiar.proyecto_integrador_montanas.utilities.*;


public class IncidenciasRecycler extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Incidencias> datos;
    AdapterIncidencias adapter;
    LinearLayoutManager ll;
    private Incidencias inci = null;
    private String clave;
    private DatabaseReference dbR;
    private ChildEventListener cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidencias_recycler);
        rv = findViewById(R.id.rvIncidencias);

        datos = new ArrayList<Incidencias>();
        adapter = new AdapterIncidencias()(datos);

        ll = new LinearLayoutManager(this);

        rv.setLayoutManager(ll);
        rv.setAdapter(adapter);
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = rv.getChildAdapterPosition(v);
                coche = datos.get(index);
                coche.toString();
                clave = coche.getId();
                System.out.println("clave: " + coche.getId() + coche.getPrecio());
            }
        });
        dbR = FirebaseDatabase.getInstance().getReference().child("coche");

        addChildEventListener();

    }
    }

}
