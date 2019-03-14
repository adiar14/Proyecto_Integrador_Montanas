package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.naturex.adiar.proyecto_integrador_montanas.adapters.AdapterRutas;
import com.naturex.adiar.proyecto_integrador_montanas.db.RutaDataSource;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;
import com.naturex.adiar.proyecto_integrador_montanas.utilities.ConexionSQLiteHelper;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Intent LogIn;

    private LinearLayoutManager lr;
    ArrayList<Ruta> listaRutas;
    RecyclerView recyclerViewRuta;
    private AdapterRutas adapter;
    RutaDataSource rms;
    ConexionSQLiteHelper conn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_voluntarios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarV);
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

        //Activities
        LogIn = new Intent(this, LogInActivity.class);



       /* LottieAnimationView fab = (LottieAnimationView) findViewById(R.id.fabBuscar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutV);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewV);
        navigationView.setNavigationItemSelectedListener(this);

    }



   @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutV);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_voluntarios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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

        if (id == R.id.nav_cuentaV){
            startActivity(LogIn);
            finish();
        } else if (id == R.id.nav_likes) {

        } else if (id == R.id.nav_sugerencias) {

        } else if (id == R.id.nav_ajustes) {
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {//En el proyecto hay que direccionarlo al Splash
            /*Intent backSLogIN = new Intent(this, LogInActivity.class);
            startActivity(backSLogIN);
            finish();
*/
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutV);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
