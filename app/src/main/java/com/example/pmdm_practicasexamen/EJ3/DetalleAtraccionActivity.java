package com.example.pmdm_practicasexamen.EJ3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_practicasexamen.EJ3.adapters.ComentariosAdapter;
import com.example.pmdm_practicasexamen.EJ3.models.AtraccionResponse;
import com.example.pmdm_practicasexamen.EJ3.viewModels.AtraccionesViewModel;
import com.example.pmdm_practicasexamen.R;

public class DetalleAtraccionActivity extends AppCompatActivity {

    AtraccionesViewModel vm;
    LiveData<AtraccionResponse> data;
    TextView nombre, descripcion, ocupantes;
    RecyclerView rw;
    ComentariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_atraccion);

        nombre = findViewById(R.id.nombre);
        descripcion = findViewById(R.id.descripcion);
        ocupantes = findViewById(R.id.ocupantes);
        rw = findViewById(R.id.comentarios);
        adapter = new ComentariosAdapter();

        rw.setLayoutManager(new LinearLayoutManager(this));
        rw.setAdapter(adapter);

        Intent intent = getIntent();

        int id = intent.getIntExtra(AtraccionesActivity.EXTRA_ID, 1);

        vm = new ViewModelProvider(this).get(AtraccionesViewModel.class);

        vm.getAtraccion(id);

        data = vm.getAtraccionResponseLiveData();

        data.observe(this, (data) -> {
            if (data != null) {
                nombre.setText(data.getNombre());
                descripcion.setText(data.getDescripcion());
                ocupantes.setText(""+data.getOcupantes());
                adapter.setComentarios(data.getComentarios());
            }
        });
    }
}