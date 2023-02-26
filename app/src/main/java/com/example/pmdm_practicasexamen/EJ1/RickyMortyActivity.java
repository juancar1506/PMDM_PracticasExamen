package com.example.pmdm_practicasexamen.EJ1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_practicasexamen.EJ1.adapters.PersonajesAdapter;
import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.viewModels.CharactersViewModel;
import com.example.pmdm_practicasexamen.R;

public class RickyMortyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonajesAdapter adapter;
    CharactersViewModel cm;
    LiveData<ApiResponse> data;

    Button anterior,siguiente;

    int page_inicial = 1;
    int page_final;
    int page_actual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricky_morty);
        adapter = new PersonajesAdapter();
        // Listado
        recyclerView = findViewById(R.id.vista);
        // Botones
        anterior = findViewById(R.id.anterior);
        siguiente = findViewById(R.id.siguiente);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        cm = new ViewModelProvider(this).get(CharactersViewModel.class);
        cm.init();
        cm.listarPersonajes(page_inicial);
        data = cm.getCharactersResponseLiveData();
        data.observe(this, (data) -> {
            if (data != null) {
                Log.d("DATARESPONSE",data.getInfo().getNext());
                adapter.setRespuesta(data.getCharacters());
                page_final = data.getInfo().getPages();

            }
        });

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page_actual >= page_inicial)
                cm.listarPersonajes(page_actual - 1);
                page_actual--;
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page_actual <= page_final) {
                    cm.listarPersonajes(page_actual +1);
                    page_actual++;
                }
            }
        });
    }

}