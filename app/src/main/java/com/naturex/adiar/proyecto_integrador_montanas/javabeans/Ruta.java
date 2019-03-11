package com.naturex.adiar.proyecto_integrador_montanas.javabeans;

public class Ruta {
    int id;
    String nombre;
    double longitud;
    double pendiente;
    String dificultad;
    String imagen;
    String nivelSuciedad;

    public Ruta() {
    }

    public Ruta(String nombre, double longitud, double pendiente, String dificultad, String imagen, String nivelSuciedad) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.pendiente = pendiente;
        this.dificultad = dificultad;
        this.imagen = imagen;
        this.nivelSuciedad = nivelSuciedad;
    }

    public Ruta(int id, String nombre, double longitud, double pendiente, String dificultad, String imagen, String nivelSuciedad) {
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.pendiente = pendiente;
        this.dificultad = dificultad;
        this.imagen = imagen;
        this.nivelSuciedad = nivelSuciedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getPendiente() {
        return pendiente;
    }

    public void setPendiente(double pendiente) {
        this.pendiente = pendiente;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNivelSuciedad() {
        return nivelSuciedad;
    }

    public void setNivelSuciedad(String nivelSuciedad) {
        this.nivelSuciedad = nivelSuciedad;
    }
}
