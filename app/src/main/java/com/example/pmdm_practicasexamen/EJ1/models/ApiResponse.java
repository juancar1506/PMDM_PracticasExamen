package com.example.pmdm_practicasexamen.EJ1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("info")
    @Expose
    private Info info;

    @SerializedName("results")
    @Expose
    private List<Character> characters;

    public Info getInfo() { return info; }
    public void setInfo(Info value) { this.info = value; }

    public List<Character> getCharacters() { return characters; }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
