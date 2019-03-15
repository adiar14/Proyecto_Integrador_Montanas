package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeVoluntariosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseUser usuarioActual;
    private FirebaseAuth mAuth;


    TextView navNombreUsuario;
    TextView navUsuarioEmail;
    ImageView navUsuarioImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Init Firebase
        mAuth = FirebaseAuth.getInstance();
        usuarioActual = mAuth.getCurrentUser();





        LottieAnimationView fab = (LottieAnimationView) findViewById(R.id.fabAniadir);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incidencias(view);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        updateNavCabecero();
    }


    public void incidencias(View v){
        Intent i = new Intent(this, AltaIncidencia.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_home_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       /* int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navig) {
            return true;
        }

        */
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cuenta){
            // Handle the camera action
        } else if (id == R.id.nav_misGrupos) {

        } else if (id == R.id.nav_notificaciones) {

        } else if (id == R.id.nav_ayuda) {

        } else if (id == R.id.nav_salir) {//En el proyecto hay que direccionarlo al Splash
            Intent backSLogIN = new Intent(this, LogInActivity.class);
            startActivity(backSLogIN);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateNavCabecero() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View actualizarCabecero = navigationView.getHeaderView(0);

        navNombreUsuario = actualizarCabecero.findViewById(R.id.navUsuarioNombre);
        navUsuarioEmail = actualizarCabecero.findViewById(R.id.navUsuarioEmail);
        navUsuarioImagen = actualizarCabecero.findViewById(R.id.navUsuarioImgPerfil);


        navNombreUsuario.setText(usuarioActual.getDisplayName());
        navUsuarioEmail.setText(usuarioActual.getEmail());
        Glide.with(this).load(usuarioActual.getPhotoUrl()).into(navUsuarioImagen);
    }
}
