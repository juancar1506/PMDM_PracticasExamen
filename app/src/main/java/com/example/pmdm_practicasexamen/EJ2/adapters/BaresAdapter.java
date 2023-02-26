package com.example.pmdm_practicasexamen.EJ2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_practicasexamen.EJ2.models.BaresResponse;
import com.example.pmdm_practicasexamen.R;

import java.util.ArrayList;
import java.util.List;


public class BaresAdapter extends RecyclerView.Adapter<BaresAdapter.BaresResultHolder> {

    private List<BaresResponse> result = new ArrayList<>();

    @NonNull
    @Override
    public BaresAdapter.BaresResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_bares, parent, false);
        return new BaresResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaresResultHolder holder, int position) {
        BaresResponse bar = result.get(position);

        holder.nombre.setText(bar.getNombre());
        holder.descripcion.setText(bar.getDescripcion());
        holder.estrellas.setText(String.format(""+bar.getEstrellas()));
    }

    @Override
    public int getItemCount() { return this.result.size(); }

    public void setResult(List<BaresResponse> result) {
        this.result = result;
        notifyDataSetChanged();
    }

    class BaresResultHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView descripcion;
        private TextView estrellas;

        public BaresResultHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            estrellas = itemView.findViewById(R.id.estrellas);
        }
    }
}
