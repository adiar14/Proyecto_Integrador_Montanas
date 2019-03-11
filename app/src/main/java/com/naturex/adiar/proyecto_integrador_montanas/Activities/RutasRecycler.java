package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.adapters.AdapterRutas;
import com.naturex.adiar.proyecto_integrador_montanas.db.RutaDataSource;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;
import com.naturex.adiar.proyecto_integrador_montanas.utilities.*;


public class RutasRecycler extends AppCompatActivity {
    private LinearLayoutManager lr;
    ArrayList<Ruta> listaRutas;
    RecyclerView recyclerViewRuta;
    private AdapterRutas adapter;
    RutaDataSource rms;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        listaRutas = new ArrayList<>();
        rms = new RutaDataSource(this);
        listaRutas=rms.consultarRuta();
        recyclerViewRuta = findViewById(R.id.rvRutas);
        lr = new LinearLayoutManager(this);
        recyclerViewRuta.setLayoutManager(lr);
        adapter = new AdapterRutas(listaRutas);
        recyclerViewRuta.setAdapter(adapter);
        recyclerViewRuta.setHasFixedSize(true);
    }

}
