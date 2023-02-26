package com.example.pmdm_practicasexamen.EJ1.viewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.models.Character;
import com.example.pmdm_practicasexamen.EJ1.repository.CharacterRepository;

public class CharactersViewModel extends AndroidViewModel {

    private CharacterRepository characterRepository;
    private LiveData<ApiResponse> charactersResponseLiveData;
    private  LiveData<Character> personajeLiveData;
    public CharactersViewModel(@NonNull Application application) {
        super(application);

        characterRepository = new CharacterRepository();
        charactersResponseLiveData = characterRepository.getCharacterResponseMutableLiveData();
        personajeLiveData =  characterRepository.getPersonajeResponseMutableLiveData();
    }


    public void listarPersonajes (int page) {
        characterRepository.listadoCaracters(page);
    }

    public void detallePersonaje (int id) { characterRepository.DetallePersonaje(id);}

    public LiveData<ApiResponse> getCharactersResponseLiveData () {
        return charactersResponseLiveData;
    }

    public LiveData<Character> getPersonajeLiveData() {
        return personajeLiveData;
    }
}
