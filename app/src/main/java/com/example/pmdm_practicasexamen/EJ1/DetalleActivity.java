package com.example.pmdm_practicasexamen.EJ1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.pmdm_practicasexamen.EJ1.models.Character;
import com.example.pmdm_practicasexamen.EJ1.viewModels.CharactersViewModel;
import com.example.pmdm_practicasexamen.R;

public class DetalleActivity extends AppCompatActivity {

    CharactersViewModel cm;
    LiveData<Character> data;

    // vista
    ImageView avatar;
    TextView name, status, species, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        avatar = findViewById(R.id.avatar);
        name = findViewById(R.id.name);
        status = findViewById(R.id.status);
        species = findViewById(R.id.species);
        gender = findViewById(R.id.gender);

        Intent intent = getIntent();

        int id = intent.getIntExtra(RickyMortyActivity.EXTRA_ID, 1);

        cm = new ViewModelProvider(this).get(CharactersViewModel.class);

        cm.detallePersonaje(id);

        data = cm.getPersonajeLiveData();

        data.observe(this, (data) -> {
            if (data != null) {
                if (data.getImage() != null){
                    Glide.with(this)
                            .load(data.getImage())
                            .into(avatar);
                }
                name.setText(data.getName());
                status.setText(data.getStatus());
                species.setText(data.getStatus());
                gender.setText(data.getGender());
            }
        });
    }
}