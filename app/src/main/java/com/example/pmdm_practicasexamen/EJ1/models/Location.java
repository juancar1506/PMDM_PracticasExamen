package com.example.pmdm_practicasexamen.EJ1.models;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }
}
