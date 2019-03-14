package com.naturex.adiar.proyecto_integrador_montanas.javabeans;

public class Incidencia {
    String descripcion;
    String imagen;
    String id;

    public Incidencia(String descripcion, String imagen) {
        this.descripcion = descripcion;
        this.imagen=imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
