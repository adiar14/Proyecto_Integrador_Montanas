package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.adapters.AdapterIncidencia;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Incidencia;



public class IncidenciasRecycler extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Incidencia> datos;
    AdapterIncidencia adapter;
    LinearLayoutManager ll;
    private DatabaseReference dbR;
    private ChildEventListener cel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidencias);
        datos = new ArrayList<Incidencia>();
        adapter = new AdapterIncidencia(datos, this);
        rv = findViewById(R.id.rvIncidencias);


        ll = new LinearLayoutManager(this);
        rv.setLayoutManager(ll);
        rv.setAdapter(adapter);
        rv.setItemAnimator(new DefaultItemAnimator());

        dbR = FirebaseDatabase.getInstance().getReference().child("incidencia");
        addChildEventListener();
    }
    private void addChildEventListener() {
        if (cel == null) {
            cel = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Incidencia");
                    Incidencia c = dataSnapshot.getValue(Incidencia.class);
                    datos.add(c);
                    adapter.notifyItemInserted(datos.size()-1);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    System.out.println("Incidencia");
                    Incidencia c = dataSnapshot.getValue(Incidencia.class);

                    int pos = 0;
                    for (int i = 0; i < datos.size(); i++) {
                        if (datos.get(i).getId().equals(c.getId())) {

                            datos.set(i, c);
                            pos = i;

                        }
                    }
                    adapter.notifyItemChanged(pos);
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };

            dbR.addChildEventListener(cel);
        }
    }
}
