package com.example.pmdm_practicasexamen.EJ1.service;

import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.models.Character;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RickMortyService {
    @GET("character")
    Call<ApiResponse> getCharacters(@Query("page") int page);

    @GET("character/{id}")
    Call<Character> getCharacter(@Path("id") int id);
}
