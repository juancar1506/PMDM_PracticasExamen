package com.example.pmdm_practicasexamen.EJ2.services;

import com.example.pmdm_practicasexamen.EJ2.models.BaresResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaresService {

    @GET("bares")
    Call<List<BaresResponse>> getBares(@Query("estrellas") Integer estrella);
}
