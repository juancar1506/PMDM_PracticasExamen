package com.example.pmdm_practicasexamen.EJ3.service;

import com.example.pmdm_practicasexamen.EJ3.models.AtraccionResponse;
import com.example.pmdm_practicasexamen.EJ3.models.AtraccionesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AtraccionService {

    @GET("atracciones")
    Call<List<AtraccionesResponse>> getAtracciones();

    @GET("atracciones/{id}")
    Call<AtraccionResponse> getAtraccion(@Path("id") int id);
}
