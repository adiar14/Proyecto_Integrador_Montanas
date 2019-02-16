package com.example.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.adiar.proyecto_integrador_montanas.R;

public class ScrollingActivityPublicHome extends AppCompatActivity {
    private Intent voluntariosLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_public_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Union al avtivity voluntarios
        voluntariosLogIn = new Intent(this, LogInActivity.class);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Accederas a las últimasnoticias para voluntarios", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(voluntariosLogIn);
                finish();
            }
        });
    }
}
