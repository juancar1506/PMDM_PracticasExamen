package com.example.pmdm_practicasexamen.EJ1.models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<C> {

    @SerializedName("info")
    private Info info;
    @SerializedName("results")
    private Character[] characters;

    public Info getInfo() { return info; }
    public void setInfo(Info value) { this.info = value; }

    public Character[] getCharacters() { return characters; }
    public void setCharacters(Character[] value) { this.characters = value; }
}
