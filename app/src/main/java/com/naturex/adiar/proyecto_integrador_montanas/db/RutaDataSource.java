package com.naturex.adiar.proyecto_integrador_montanas.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.naturex.adiar.proyecto_integrador_montanas.javabeans.Ruta;

import java.util.ArrayList;

public class RutaDataSource {


    RutasSQLiteHelper rsqh;
    private Context contexto;

    public RutaDataSource(Context contexto) {
        this.contexto = contexto;
        rsqh = new RutasSQLiteHelper(contexto);
    }

    public SQLiteDatabase openReadable(){
        return rsqh.getReadableDatabase();
    }

    public void close(SQLiteDatabase database) {
        database.close();
    }


    public ArrayList<Ruta> consultarRuta(){
        SQLiteDatabase database = openReadable();
        ArrayList<Ruta> lista = new ArrayList<>();



        String select = "SELECT *" + " FROM " +
                RutaContract.RutaEntry.TABLE_NAME;

        Cursor cursor = database.rawQuery(select,null);
        Ruta ru = null;
        int id;
        String nombre;
        double longitud;
        double pendiente;
        String dificultad;
        String imagen;
        String nivelSuciedad;


        while(cursor.moveToNext()){
            id = cursor.getInt(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_ID));
            nombre = cursor.getString(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_NAME));
            longitud = cursor.getDouble(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_LONGITUD));
            pendiente = cursor.getDouble(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_PENDIENTE));
            dificultad = cursor.getString(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_DIFICULTAD));
            imagen = cursor.getString(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_IMAGEN));
            nivelSuciedad = cursor.getString(cursor.getColumnIndex(RutaContract.RutaEntry.COLUMN_SUCIEDAD));
            ru = new Ruta(id,nombre,longitud,pendiente,dificultad,imagen,nivelSuciedad);
            lista.add(ru);
        }


        cursor.close();
        database.close();
        return lista;

    }

}
