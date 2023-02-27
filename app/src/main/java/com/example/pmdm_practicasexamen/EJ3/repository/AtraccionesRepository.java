package com.example.pmdm_practicasexamen.EJ3.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.pmdm_practicasexamen.EJ3.models.AtraccionResponse;
import com.example.pmdm_practicasexamen.EJ3.models.AtraccionesResponse;
import com.example.pmdm_practicasexamen.EJ3.service.AtraccionService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AtraccionesRepository {
    private static final String BASE_URL = "http://192.168.1.44:8000/pmdm/api/";

    private AtraccionService atraccionService;
    private MutableLiveData<List<AtraccionesResponse>> atraccionesMutableLiveData;
    private MutableLiveData<AtraccionResponse> atraccionResponseMutableLiveData;

    public AtraccionesRepository () {
        atraccionesMutableLiveData = new MutableLiveData<>();
        atraccionResponseMutableLiveData = new MutableLiveData<>();

        atraccionService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AtraccionService.class);
    }

    public void listadoAtracciones () {
        atraccionService
                .getAtracciones()
                .enqueue(new Callback<List<AtraccionesResponse>>() {
                    @Override
                    public void onResponse(Call<List<AtraccionesResponse>> call, Response<List<AtraccionesResponse>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            atraccionesMutableLiveData.postValue(response.body());
                        } else {
                            atraccionesMutableLiveData.postValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<AtraccionesResponse>> call, Throwable t) {
                        Log.d("errorRepositroy", "Fallo en el repositorio");
                        Log.d("errorRepositroy", t.getMessage());
                        atraccionesMutableLiveData.postValue(null);
                    }
                });
    }

    public void detalleAtraccion (int id) {
        atraccionService
                .getAtraccion(id)
                .enqueue(new Callback<AtraccionResponse>() {
                    @Override
                    public void onResponse(Call<AtraccionResponse> call, Response<AtraccionResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            atraccionResponseMutableLiveData.postValue(response.body());
                        } else {
                         atraccionResponseMutableLiveData.postValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<AtraccionResponse> call, Throwable t) {
                        Log.d("errorRepositroy", "Fallo en el repositorio");
                        Log.d("errorRepositroy", t.getMessage());
                        atraccionResponseMutableLiveData.postValue(null);
                    }
                });
    }

    public MutableLiveData<List<AtraccionesResponse>> getAtraccionesMutableLiveData() {
        return atraccionesMutableLiveData;
    }

    public MutableLiveData<AtraccionResponse> getAtraccionResponseMutableLiveData() {
        return atraccionResponseMutableLiveData;
    }
}
