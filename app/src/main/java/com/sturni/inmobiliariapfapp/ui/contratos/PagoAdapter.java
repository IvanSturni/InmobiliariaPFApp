package com.sturni.inmobiliariapfapp.ui.contratos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Pago;

import java.util.ArrayList;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.PagoViewHolder> {
    private ArrayList<Pago> lista;
    private Context context;

    public PagoAdapter(Context context, ArrayList<Pago> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public PagoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fila_pago, parent, false);
        return new PagoViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PagoViewHolder holder, int position) {
        holder.tvPagCodigo.setText(""+lista.get(position).getIdPago());
        holder.tvPagNumero.setText(""+lista.get(position).getNumero());
        holder.tvPagFecha.setText(lista.get(position).getFechaDePago());
        holder.tvPagImporte.setText("$"+lista.get(position).getImporte());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class PagoViewHolder extends RecyclerView.ViewHolder {
        TextView tvPagNumero, tvPagCodigo, tvPagFecha, tvPagImporte;

        public PagoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPagCodigo = itemView.findViewById(R.id.tvPagCodigo);
            tvPagNumero = itemView.findViewById(R.id.tvPagNumero);
            tvPagFecha = itemView.findViewById(R.id.tvPagFecha);
            tvPagImporte= itemView.findViewById(R.id.tvPagImporte);
        }
    }
}
