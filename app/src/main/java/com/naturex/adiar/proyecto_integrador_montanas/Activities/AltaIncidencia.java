package com.naturex.adiar.proyecto_integrador_montanas.Activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.naturex.adiar.proyecto_integrador_montanas.R;
import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Incidencia;

import java.util.UUID;

public class AltaIncidencia  extends AppCompatActivity {
    private DatabaseReference dbR;
    private ChildEventListener cel;
    static int PreqCode = 1;
    static int REQUESCODE = 1;
    ImageView imagenIncidencia;
    private EditText etDesc;
    private Uri filePath;
    private Button btn;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidencias);
        storage = FirebaseStorage.getInstance();
        storageReference=storage.getReference();
        btn = findViewById(R.id.btnAltaIncidencia);
        etDesc = findViewById(R.id.etDescripcionIncidencia);

        dbR = FirebaseDatabase.getInstance().getReference().child("incidencia");
        imagenIncidencia = findViewById(R.id.regIncidenciaImagen);
        imagenIncidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= 22){
                    checkAndrequestForPermission();
                }else{
                    openGallery();
                }



            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aniadir();
            }
        });
    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }
    private void checkAndrequestForPermission() {
        if(ContextCompat.checkSelfPermission(AltaIncidencia.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(AltaIncidencia.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(getBaseContext(), getString(R.string.permisoIMG), Toast.LENGTH_SHORT).show();
            }else{
                ActivityCompat.requestPermissions(AltaIncidencia.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PreqCode);
            }
        }else{
            openGallery();

        }
    }
    public void aniadir() {


        try{

            //if(mat.isEmpty()||mod.isEmpty()||col.isEmpty)
            if(filePath != null)
            {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Uploading...");
                progressDialog.show();

                StorageReference ref = storageReference.child("incidencias/"+ UUID.randomUUID().toString());
                ref.putFile(filePath)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                progressDialog.dismiss();
                                Toast.makeText(AltaIncidencia.this, "Uploaded", Toast.LENGTH_SHORT).show();
                                String clave = dbR.push().getKey();
                                String desc = etDesc.getText().toString();
                                Incidencia inci = new Incidencia(desc, storageReference.getDownloadUrl().toString());
                                dbR.child(clave).setValue(inci);
                                inci.setId(clave);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(AltaIncidencia.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                        .getTotalByteCount());
                                progressDialog.setMessage("Uploaded "+(int)progress+"%");
                            }
                        });
            }

        }catch(NumberFormatException e){
        }


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUESCODE && data != null){
            filePath = data.getData();
            imagenIncidencia.setImageURI(filePath);
        }
    }
}