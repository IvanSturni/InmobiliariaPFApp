package com.sturni.inmobiliariapfapp.ui.contratos;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Inmueble;

import java.util.ArrayList;

public class ContratoAdapter extends RecyclerView.Adapter<ContratoAdapter.ContratoViewHolder> {
    private ArrayList<Inmueble> lista;
    private Context context;

    public ContratoAdapter(Context context, ArrayList<Inmueble> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ContratoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fila_contrato, parent, false);
        return new ContratoViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ContratoViewHolder holder, int position) {
        holder.tvConDireccion.setText(lista.get(position).getDireccion());
        holder.tvConPrecio.setText("$"+lista.get(position).getPrecio());
        String imgsrc = lista.get(position).getImagen();
        Glide.with(context)
                .load(lista.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivConFoto);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ContratoViewHolder extends RecyclerView.ViewHolder {
        TextView tvConDireccion, tvConPrecio;
        ImageView ivConFoto;
        ImageButton ibConPagos;
        ConstraintLayout clContrato;

        public ContratoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvConDireccion = itemView.findViewById(R.id.tvConDireccion);
            tvConPrecio = itemView.findViewById(R.id.tvConPrecio);
            ivConFoto = itemView.findViewById(R.id.ivConFoto);
            ibConPagos = itemView.findViewById(R.id.ibConPagos);
            clContrato = itemView.findViewById(R.id.clContrato);

            // Para ver detalles del contrato del inmueble
            clContrato.setOnClickListener(v -> {
                // TODO: Implementar fragment de detalles del contrato
                Log.d("TODO", "ContratoViewHolder: Ver detalles del contrato");
            });

            // Para ver pagos del contrato del inmueble
            ibConPagos.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Inmueble", lista.get(getAdapterPosition()));
                Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.pagosFragment, bundle);
                // onClick: Ver pagos de contrato de inmueble con id lista.get(position).getIdInmueble()
            });

        }
    }
}
