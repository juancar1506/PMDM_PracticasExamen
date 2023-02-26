package com.example.pmdm_practicasexamen.EJ1.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pmdm_practicasexamen.EJ1.models.ApiResponse;
import com.example.pmdm_practicasexamen.EJ1.models.Character;
import com.example.pmdm_practicasexamen.R;

import java.util.ArrayList;
import java.util.List;

public class PersonajesAdapter extends RecyclerView.Adapter<PersonajesAdapter.PersonajesResultHolder> {

    private List<Character> respuesta = new ArrayList<>();

    // Para acceder al detalle
    public interface ItemClickListener {
        void onClick(View view, int id);
    }

    private ItemClickListener clickListener;

    public void setClickListener (ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PersonajesAdapter.PersonajesResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View iteview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_personajes, parent, false);
        return new PersonajesResultHolder(iteview);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajesResultHolder holder, int position) {
        Character character = respuesta.get(position);

        holder.personaje_nombre.setText(character.getName());

        if (character.getImage() != null) {
            Glide.with(holder.itemView)
                    .load(character.getImage())
                    .into(holder.sprite);
        }

    }

    @Override
    public int getItemCount() {
        return this.respuesta.size();
    }

    public void setRespuesta (List<Character> characters) {
        this.respuesta = characters;
        notifyDataSetChanged();
    }

    class PersonajesResultHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView personaje_nombre;
        private ImageView sprite;

        public PersonajesResultHolder(@NonNull View itemView) {
            super(itemView);

            personaje_nombre = itemView.findViewById(R.id.personaje_nombre);
            sprite = itemView.findViewById(R.id.sprite);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, respuesta.get(getBindingAdapterPosition()).getId());
            }
        }
    }
}
