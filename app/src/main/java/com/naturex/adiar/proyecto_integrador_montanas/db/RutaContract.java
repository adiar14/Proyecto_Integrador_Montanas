package com.naturex.adiar.proyecto_integrador_montanas.db;

import android.provider.BaseColumns;

public class RutaContract {

    public static abstract class RutaEntry implements BaseColumns {

        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "nombre";
        public static final String COLUMN_LONGITUD = "longitud";
        public static final String COLUMN_PENDIENTE = "pendiente";
        public static final String COLUMN_DIFICULTAD = "dificultad";
        public static final String COLUMN_IMAGEN = "imagen";
        public static final String COLUMN_SUCIEDAD = "suciedad";
        public static final String TABLE_NAME = "RUTAS";


    }
}
