package com.example.pmdm_practicasexamen.EJ3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AtraccionesResponse {

    @SerializedName("url")
    @Expose
    String url;

    @SerializedName("nombre")
    @Expose
    String nombre;

    @SerializedName("descripcion")
    @Expose
    String descripcion;

    @SerializedName("ocupantes")
    @Expose
    int ocupantes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }
}
