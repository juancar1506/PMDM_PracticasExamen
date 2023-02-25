package com.example.pmdm_practicasexamen.EJ1.service;

import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.models.Character;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickMortyService {
    @GET("character")
    Call<ApiResponse<Character>> getCharacters();
}
