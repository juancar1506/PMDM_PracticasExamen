package com.example.pmdm_practicasexamen.EJ3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_practicasexamen.EJ3.models.Comentario;
import com.example.pmdm_practicasexamen.R;

import java.util.ArrayList;
import java.util.List;

public class ComentariosAdapter extends RecyclerView.Adapter<ComentariosAdapter.ComentariosResultHolder> {

    List<Comentario> comentarios = new ArrayList<>();

    @NonNull
    @Override
    public ComentariosAdapter.ComentariosResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comentarios_holder, parent, false);
        return new ComentariosResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentariosAdapter.ComentariosResultHolder holder, int position) {
        Comentario comentario = comentarios.get(position);

        holder.texto.setText(comentario.getTexto());
    }

    @Override
    public int getItemCount() {
        return this.comentarios.size();
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
        notifyDataSetChanged();
    }

    class ComentariosResultHolder extends RecyclerView.ViewHolder {

        TextView texto;

        public ComentariosResultHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.texto);

        }
    }
}
