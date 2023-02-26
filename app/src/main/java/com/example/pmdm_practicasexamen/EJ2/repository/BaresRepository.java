package com.example.pmdm_practicasexamen.EJ2.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pmdm_practicasexamen.EJ2.models.BaresResponse;
import com.example.pmdm_practicasexamen.EJ2.services.BaresService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaresRepository {
    private static final String BASE_URL = "http://IP:PORT/pmdm/api/";
    private static final String FORMAT_FECHA = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private BaresService baresService;
    private MutableLiveData<List<BaresResponse>> baresResponseMutableLiveData;

    public BaresRepository () {
        baresResponseMutableLiveData = new MutableLiveData<>();
        Gson gson = new GsonBuilder().setDateFormat(FORMAT_FECHA).create();
        baresService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(BaresService.class);
    }

    public void listadoBares (Integer estrellas) {
        baresService
                .getBares(estrellas)
                .enqueue(new Callback<List<BaresResponse>>() {
                    @Override
                    public void onResponse(Call<List<BaresResponse>> call, Response<List<BaresResponse>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            baresResponseMutableLiveData.postValue(response.body());
                        } else {
                            baresResponseMutableLiveData.postValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<BaresResponse>> call, Throwable t) {
                        Log.d("errorRepositroy", "Fallo en el repositorio");
                        Log.d("errorRepositroy", t.getMessage());
                        baresResponseMutableLiveData.postValue(null);
                    }
                });
    }


    public MutableLiveData<List<BaresResponse>> getBaresResponseMutableLiveData() {
        return baresResponseMutableLiveData;
    }
}
