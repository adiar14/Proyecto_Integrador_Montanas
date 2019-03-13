package com.naturex.adiar.proyecto_integrador_montanas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;

import java.util.ArrayList;

public class RutasSQLiteHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "RUTAS";
    static final int DATABASE_VERSION = 2;
    private ArrayList<Ruta> cargaInicial = new ArrayList<>();
    static final String CREATE_TABLE_RUTAS =
            "CREATE TABLE "+ RutaContract.RutaEntry.TABLE_NAME+ "( "+
                    RutaContract.RutaEntry.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    RutaContract.RutaEntry.COLUMN_NAME+" TEXT NOT NULL UNIQUE," +
                    RutaContract.RutaEntry.COLUMN_LONGITUD+" DOUBLE NOT NULL UNIQUE," +
                    RutaContract.RutaEntry.COLUMN_PENDIENTE+" INTEGER NOT NULL UNIQUE," +
                    RutaContract.RutaEntry.COLUMN_DIFICULTAD+" TEXT NOT NULL, " +
                    RutaContract.RutaEntry.COLUMN_IMAGEN+" TEXT NOT NULL, " +
                    RutaContract.RutaEntry.COLUMN_SUCIEDAD+" TEXT NOT NULL);" ;

    public RutasSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_RUTAS);
        rellenarArray();
        cargaDatosInicial(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +
                RutaContract.RutaEntry.TABLE_NAME);
        onCreate(db);
    }

    private void rellenarArray() {

        cargaInicial.add(new Ruta("Pico de Abantos",  9.09, 709, "Fácil","/img1.jpg", "Bajo"));
        cargaInicial.add(new Ruta("Frente del Agua",  16.19, 336, "Fácil","/img2.jpg", "Medio"));
        cargaInicial.add(new Ruta("Patones de Arriba",  11.06, 498, "Fácil","/img3.jpg", "Bajo"));
        cargaInicial.add(new Ruta("Cuerda Larga",  20.64, 1035, "Medio","/img4.jpg", "Bajo"));
        cargaInicial.add(new Ruta("Bola del Mundo",  37.98, 1806, "Difíci","/img5.jpg", "Alto"));
    }

    private void cargaDatosInicial(SQLiteDatabase db) {
        db.beginTransaction();
        ContentValues rutaVal = null;
        for (int i = 0; i < cargaInicial.size(); i++){

            rutaVal = new ContentValues();
            rutaVal.put(RutaContract.RutaEntry.COLUMN_NAME, cargaInicial.get(i).getNombre());
            rutaVal.put(RutaContract.RutaEntry.COLUMN_LONGITUD, cargaInicial.get(i).getLongitud());
            rutaVal.put(RutaContract.RutaEntry.COLUMN_PENDIENTE, cargaInicial.get(i).getPendiente());
            rutaVal.put(RutaContract.RutaEntry.COLUMN_DIFICULTAD, cargaInicial.get(i).getDificultad());
            rutaVal.put(RutaContract.RutaEntry.COLUMN_IMAGEN, cargaInicial.get(i).getImagen());
            rutaVal.put(RutaContract.RutaEntry.COLUMN_SUCIEDAD, cargaInicial.get(i).getNivelSuciedad());

            db.insert(RutaContract.RutaEntry.TABLE_NAME,null, rutaVal);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}