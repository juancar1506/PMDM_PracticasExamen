package com.example.pmdm_practicasexamen.EJ2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_practicasexamen.EJ2.adapters.BaresAdapter;
import com.example.pmdm_practicasexamen.EJ2.models.BaresResponse;
import com.example.pmdm_practicasexamen.EJ2.viewModel.BaresViewModel;
import com.example.pmdm_practicasexamen.R;

import java.util.List;

public class BaresActivity extends AppCompatActivity {

    BaresAdapter adapter;
    BaresViewModel vm;
    RecyclerView rw;
    LiveData<List<BaresResponse>> data;
    Button filtrar;
    EditText estrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);
        adapter = new BaresAdapter();
        estrellas = findViewById(R.id.estrellas);
        filtrar = findViewById(R.id.filtrar);

        rw = findViewById(R.id.bares);

        rw.setLayoutManager(new LinearLayoutManager(this));
        rw.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(BaresViewModel.class);

        vm.listarBares(null);
        data = vm.getBaresListLiveData();

        data.observe(this, (bares) -> {
            if (data != null) {
                adapter.setResult(bares);
            }
        });

        filtrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer estrella = null;
                try {
                    estrella = Integer.parseInt(estrellas.getText().toString());
                    vm.listarBares(estrella);
                } catch (NumberFormatException e) {
                    Log.e("ERROR_NUYMBER", e.getMessage());
                }
            }
        });
    }
}