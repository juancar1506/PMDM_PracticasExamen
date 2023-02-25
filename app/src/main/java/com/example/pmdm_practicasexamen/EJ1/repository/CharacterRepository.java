package com.example.pmdm_practicasexamen.EJ1.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.service.RickMortyService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterRepository {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/";

    private RickMortyService characterService;
    private MutableLiveData<ApiResponse> characterResponseLiveData;


    public CharacterRepository() {
        characterResponseLiveData = new MutableLiveData<>();

        characterService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickMortyService.class);
    }


}
