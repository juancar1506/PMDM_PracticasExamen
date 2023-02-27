package com.example.pmdm_practicasexamen.EJ3.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pmdm_practicasexamen.EJ3.models.AtraccionResponse;
import com.example.pmdm_practicasexamen.EJ3.models.AtraccionesResponse;
import com.example.pmdm_practicasexamen.EJ3.repository.AtraccionesRepository;

import java.util.List;

public class AtraccionesViewModel extends AndroidViewModel {
    private AtraccionesRepository atraccionesRepository;

    private LiveData<List<AtraccionesResponse>> atraccionesLiveData;

    private LiveData<AtraccionResponse> atraccionResponseLiveData;

    public AtraccionesViewModel(@NonNull Application application) {
        super(application);
        atraccionesRepository = new AtraccionesRepository();
        atraccionesLiveData = atraccionesRepository.getAtraccionesMutableLiveData();
        atraccionResponseLiveData = atraccionesRepository.getAtraccionResponseMutableLiveData();
    }

    public void getAtracciones () {
        atraccionesRepository.listadoAtracciones();
    }

    public void getAtraccion (int id) {
        atraccionesRepository.detalleAtraccion(id);
    }

    public LiveData<List<AtraccionesResponse>> getAtraccionesLiveData() {
        return atraccionesLiveData;
    }

    public LiveData<AtraccionResponse> getAtraccionResponseLiveData() {
        return atraccionResponseLiveData;
    }
}
