package com.example.pmdm_practicasexamen.EJ3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_practicasexamen.EJ3.models.AtraccionesResponse;
import com.example.pmdm_practicasexamen.R;

import java.util.ArrayList;
import java.util.List;

public class AtraccionesAdapter extends RecyclerView.Adapter<AtraccionesAdapter.AtraccionesResultHolder> {

    private List<AtraccionesResponse> atracciones = new ArrayList<>();

    public interface ItemClickListener {
        void onClick(View v, int id);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AtraccionesAdapter.AtraccionesResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.atracciones_holder, parent, false);
        return new AtraccionesResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AtraccionesAdapter.AtraccionesResultHolder holder, int position) {
        AtraccionesResponse atraccion = atracciones.get(position);
        holder.nombre.setText(atraccion.getNombre());
        holder.descripcion.setText(atraccion.getDescripcion());
        holder.ocupantes.setText(""+atraccion.getOcupantes());
    }

    @Override
    public int getItemCount() {
        return this.atracciones.size();
    }

    public void setAtracciones(List<AtraccionesResponse> atracciones) {
        this.atracciones = atracciones;
        notifyDataSetChanged();
    }

    class AtraccionesResultHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombre;
        private TextView descripcion;
        private TextView ocupantes;

        public AtraccionesResultHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            descripcion = itemView.findViewById(R.id.descripcion);
            ocupantes = itemView.findViewById(R.id.ocupantes);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, (getBindingAdapterPosition() +1) );
            }
        }
    }
}
