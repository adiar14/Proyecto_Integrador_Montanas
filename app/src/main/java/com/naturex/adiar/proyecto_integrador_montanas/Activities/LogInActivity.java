package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.airbnb.lottie.LottieAnimationView;
import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private EditText nombreUsuario, contraseña;
    private Button btnAcceso, btnRegistro;
    private LottieAnimationView barraProgreso;
    //Conexion a firebase
    private FirebaseAuth mAuth;
    //lOG IN GOOGLE
    private GoogleApiClient googleApi;
    public static final int SING_IN_CODE = 777;

    //declaramos el intent al que queramos acceder
    private Intent homeActivity;
    Toast toast;
    private Intent registrerActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        //asignar los valores de las variables
        nombreUsuario = findViewById(R.id.etId);
        contraseña = findViewById(R.id.etContrasenia);
        btnAcceso =findViewById(R.id.btnAcceso);
        btnRegistro = findViewById(R.id.btnAcceso2);
        barraProgreso =findViewById(R.id.logInBar);
        //Inicializar Firebase
        mAuth = FirebaseAuth.getInstance();

        //Iniciar el activity
        homeActivity = new Intent(this, HomeActivity.class);
        registrerActivity = new Intent(this, RegisterActivity.class);

        //gOOGLE
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApi = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();






        /*//GOOGLE AUTH
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Construye un GoogleSignInClient con las opciones especificadas por gso.
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);*/



        //aCCIONES DE LAS BARRAS DE PROGRESO
        barraProgreso.setVisibility(View.INVISIBLE);
        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barraProgreso.setVisibility(View.VISIBLE);
                btnAcceso.setVisibility(View.INVISIBLE);
                btnRegistro.setVisibility(View.INVISIBLE);

                final String idUsuario = nombreUsuario.getText().toString();
                final String contraseniaUsuario = contraseña.getText().toString();

                if(idUsuario.isEmpty() || contraseniaUsuario.isEmpty()){
                    showMessage("Verifica los datos introducidos");
                    barraProgreso.setVisibility(View.INVISIBLE);
                    btnAcceso.setVisibility(View.VISIBLE);
                    btnRegistro.setVisibility(View.VISIBLE);
                }else{
                    acceder(idUsuario, contraseniaUsuario);
                }


            }
        });




    }

    private void updateUI(GoogleSignInAccount account) {

    }

    private void acceder(String idUsuario, String contraseniaUsuario) {

            mAuth.signInWithEmailAndPassword(idUsuario, contraseniaUsuario).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        barraProgreso.setVisibility(View.VISIBLE);
                        btnAcceso.setVisibility(View.INVISIBLE);
                        btnRegistro.setVisibility(View.INVISIBLE);
                        actualizarUsuario();
                    }else{
                        showMessage(task.getException().getMessage());

                    }


                }
            });
    }

    private void actualizarUsuario() {
        startActivity(homeActivity);
        finish();

    }

    private void showMessage(String s) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(this, s, Toast.LENGTH_LONG);
        toast.show();
    }

    public void accesoRegistro(View v){
        startActivity(registrerActivity);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        
    }
}
