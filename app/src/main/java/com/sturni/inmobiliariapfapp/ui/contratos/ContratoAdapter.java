package com.sturni.inmobiliariapfapp.ui.contratos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    @Override
    public void onBindViewHolder(@NonNull ContratoViewHolder holder, int position) {
        holder.tvConDireccion.setText(lista.get(position).getDireccion());
        holder.tvConPrecio.setText("$"+lista.get(position).getPrecio());
        String imgsrc = lista.get(position).getImagen();
        Glide.with(context)
                .load(lista.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivConFoto);

        holder.ibConPagos.setOnClickListener(v -> {
            // TODO: IMPLEMENTAR DETALLES DE INQUILINO
            // Bundle bundle = new Bundle();
            // Contrato Contrato = Contratos.get(getAdapterPosition());
            // bundle.putSerializable("Contrato", Contrato);
            // Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.ContratoFragment, bundle);
            Log.d("TODO", "onClick: Ver pagos de contrato de inmueble con id " + lista.get(position).getIdInmueble());

        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ContratoViewHolder extends RecyclerView.ViewHolder {
        TextView tvConDireccion, tvConPrecio;
        ImageView ivConFoto;
        ImageButton ibConPagos;

        public ContratoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvConDireccion = itemView.findViewById(R.id.tvConDireccion);
            tvConPrecio = itemView.findViewById(R.id.tvConPrecio);
            ivConFoto = itemView.findViewById(R.id.ivConFoto);
            ibConPagos = itemView.findViewById(R.id.ibConPagos);
        }
    }
}
