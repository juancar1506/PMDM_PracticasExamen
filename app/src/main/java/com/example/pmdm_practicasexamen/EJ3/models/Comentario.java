package com.example.pmdm_practicasexamen.EJ3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comentario {

    @SerializedName("url")
    @Expose
    String url;

    @SerializedName("texto")
    @Expose
    String texto;

    @SerializedName("atraccion")
    @Expose
    String atraccion;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(String atraccion) {
        this.atraccion = atraccion;
    }
}
