package com.example.pmdm_practicasexamen.EJ1.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.repository.CharacterRepository;

public class CharactersViewModel extends AndroidViewModel {

    private CharacterRepository characterRepository;
    private LiveData<ApiResponse> charactersResponseLiveData;

    public CharactersViewModel(@NonNull Application application) {
        super(application);
    }

    public void init () {
        characterRepository = new CharacterRepository();

        charactersResponseLiveData = characterRepository.getCharacterResponseMutableLiveData();
    }

    public void listarPersonajes (int page) {
        characterRepository.listadoCaracters(page);
    }

    public LiveData<ApiResponse> getCharactersResponseLiveData () {
        return charactersResponseLiveData;
    }
}
