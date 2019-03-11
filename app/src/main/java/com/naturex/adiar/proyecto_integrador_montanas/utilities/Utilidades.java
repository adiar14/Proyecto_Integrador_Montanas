package com.naturex.adiar.proyecto_integrador_montanas.utilities;

public class Utilidades {
    //Constantes campos tabla usuario
    public static final String TABLA_RUTA="ruta";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_DIFICULTAD="dificultad";

    public static final String CREAR_TABLA_RUTA="CREATE TABLE " +
            ""+TABLA_RUTA+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_DIFICULTAD+" TEXT)";

}
