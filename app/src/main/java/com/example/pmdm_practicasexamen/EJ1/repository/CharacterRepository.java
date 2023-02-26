package com.example.pmdm_practicasexamen.EJ1.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.models.Character;
import com.example.pmdm_practicasexamen.EJ1.service.RickMortyService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterRepository {
    private static final String BASE_URL = "https://rickandmortyapi.com/api/";

    private RickMortyService characterService;
    private MutableLiveData<ApiResponse> characterResponseMutableLiveData;
    private MutableLiveData<Character> personajeResponseMutableLiveData;

    public CharacterRepository() {
        characterResponseMutableLiveData = new MutableLiveData<>();
        personajeResponseMutableLiveData = new MutableLiveData<>();

        characterService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickMortyService.class);
    }

    public void listadoCaracters (int page) {
        // Petición
        characterService
                .getCharacters(page)
                .enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse (Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("Buscando","Busacando personajes");
                            // Se asignan los valores al mutabledata
                            characterResponseMutableLiveData.postValue(response.body());
                        } else {
                            characterResponseMutableLiveData.postValue(null);
                        }
                    }

                    @Override
                    public void onFailure (Call<ApiResponse> call, Throwable t) {
                        // No hay valor.
                        Log.d("errorRepositroy", "Fallo en el repositorio");
                        Log.d("errorRepositroy", t.getMessage());
                        characterResponseMutableLiveData.postValue(null);
                    }
                });
    }

    public void DetallePersonaje (int id) {
        characterService.getCharacter(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if (response.isSuccessful() && response.body() != null) {
                    personajeResponseMutableLiveData.postValue(response.body());
                } else {
                    personajeResponseMutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                personajeResponseMutableLiveData.postValue(null);
            }
        });
    }

    public MutableLiveData<ApiResponse> getCharacterResponseMutableLiveData() {
        return characterResponseMutableLiveData;
    }

    public MutableLiveData<Character> getPersonajeResponseMutableLiveData() {
        return personajeResponseMutableLiveData;
    }
}
