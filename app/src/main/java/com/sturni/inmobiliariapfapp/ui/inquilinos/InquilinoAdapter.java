package com.sturni.inmobiliariapfapp.ui.inquilinos;

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
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.modelo.Inquilino;
import com.sturni.inmobiliariapfapp.request.ApiClient;

import java.util.ArrayList;

public class InquilinoAdapter extends RecyclerView.Adapter<InquilinoAdapter.InmuebleViewHolder> {
    private ArrayList<Inmueble> lista;
    private Context context;
    private LayoutInflater layoutInflater;

    public InquilinoAdapter(Context context, ArrayList<Inmueble> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public InmuebleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fila_inmueble, parent, false);
        return new InmuebleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InmuebleViewHolder holder, int position) {
        holder.tvDireccion.setText(lista.get(position).getDireccion());
        holder.tvPrecio.setText("$"+lista.get(position).getPrecio());
        String imgsrc = lista.get(position).getImagen();
        Glide.with(context)
                .load(lista.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivFoto);

        holder.ibDetalles.setOnClickListener(v -> {

             Bundle bundle = new Bundle();
             Inmueble inmueble = lista.get(position);
             Inquilino inquilino = ApiClient.getApi().obtenerInquilino(inmueble);
             bundle.putSerializable("inquilino", inquilino);
             Navigation.findNavController((Activity) context, R.id.nav_host_fragment).navigate(R.id.InquilinoDetalleFragment, bundle);
            Log.d("TODO", "onClick: Ver detalles de inquilino en inmueble con id " + lista.get(position).getIdInmueble());
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class InmuebleViewHolder extends RecyclerView.ViewHolder {
        TextView tvDireccion, tvPrecio;
        ImageView ivFoto;
        ImageButton ibDetalles;

        public InmuebleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            ibDetalles = itemView.findViewById(R.id.ibDetalles);
        }
    }
}
