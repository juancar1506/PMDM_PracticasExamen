package com.example.pmdm_practicasexamen.EJ2.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pmdm_practicasexamen.EJ2.models.BaresResponse;
import com.example.pmdm_practicasexamen.EJ2.repository.BaresRepository;

import java.util.List;

public class BaresViewModel  extends AndroidViewModel {

    private BaresRepository baresRepository;
    private LiveData<List<BaresResponse>> baresListLiveData;

    public BaresViewModel(@NonNull Application application) {
        super(application);
        baresRepository = new BaresRepository();
        baresListLiveData = baresRepository.getBaresResponseMutableLiveData();
    }

    public void listarBares (Integer estrellas) {
        baresRepository.listadoBares(estrellas);
    }

}
