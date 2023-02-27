package com.example.pmdm_practicasexamen.EJ3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmdm_practicasexamen.EJ3.adapters.AtraccionesAdapter;
import com.example.pmdm_practicasexamen.EJ3.models.AtraccionesResponse;
import com.example.pmdm_practicasexamen.EJ3.viewModels.AtraccionesViewModel;
import com.example.pmdm_practicasexamen.R;

import java.util.List;

public class AtraccionesActivity extends AppCompatActivity {

    public static String EXTRA_ID = "id";
    RecyclerView rw;
    AtraccionesAdapter adapter;
    AtraccionesViewModel vm;
    LiveData<List<AtraccionesResponse>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atracciones);

        // Adapter
        adapter = new AtraccionesAdapter();

        rw = findViewById(R.id.atracciones);

        rw.setLayoutManager(new LinearLayoutManager(this));
        rw.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        vm.getAtracciones();
        data = vm.getAtraccionesLiveData();

        data.observe(this, (data) -> {
            if (data != null) {
                adapter.setAtracciones(data);
            }
        });

        adapter.setClickListener(new AtraccionesAdapter.ItemClickListener() {
            @Override
            public void onClick(View v, int id) {
                Intent detalle = new Intent(getApplicationContext(), DetalleAtraccionActivity.class);
                detalle.putExtra(EXTRA_ID, id);
                startActivity(detalle);
            }
        });
    }
}