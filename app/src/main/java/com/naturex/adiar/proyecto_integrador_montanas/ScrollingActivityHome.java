package com.naturex.adiar.proyecto_integrador_montanas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.naturex.adiar.proyecto_integrador_montanas.adapters.AdapterRutas;
import com.naturex.adiar.proyecto_integrador_montanas.db.RutaDataSource;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;
import com.naturex.adiar.proyecto_integrador_montanas.utilities.ConexionSQLiteHelper;


import java.util.ArrayList;

public class ScrollingActivityHome extends AppCompatActivity {
    private LinearLayoutManager lr;
    ArrayList<Ruta> listaRutas;
    RecyclerView recyclerViewRuta;
    private AdapterRutas adapter;
    RutaDataSource rms;
    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Carga del reciclerView con los datos almacenados
        listaRutas = new ArrayList<>();
        rms = new RutaDataSource(this);
        listaRutas=rms.consultarRuta();
        recyclerViewRuta = findViewById(R.id.rvRutas);
        lr = new LinearLayoutManager(this);
        recyclerViewRuta.setLayoutManager(lr);
        adapter = new AdapterRutas(listaRutas);
        recyclerViewRuta.setAdapter(adapter);
        recyclerViewRuta.setHasFixedSize(true);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
