package com.sturni.inmobiliariapfapp.ui.inmuebles;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Inmueble;

import java.text.NumberFormat;
import java.util.Locale;

public class InmuebleFragment extends Fragment {

    private InmuebleViewModel mViewModel;
    private TextView tvInmDireccion, tvInmPrecio, tvInmTipo, tvInmAmbientes, tvInmUso;
    private ImageView ivInmFoto;
    private CheckBox cbInmDisponible;

    public InmuebleFragment() {
    }

    public static InmuebleFragment newInstance() { return new InmuebleFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inmueble_fragment, container, false);
        inicializarVista(root);
        return root;
    }

    private void inicializarVista(View root) {
        tvInmDireccion = root.findViewById(R.id.tvInmDireccion);
        tvInmPrecio = root.findViewById(R.id.tvInmPrecio);
        tvInmTipo = root.findViewById(R.id.tvInmTipo);
        tvInmAmbientes = root.findViewById(R.id.tvInmAmbientes);
        tvInmUso = root.findViewById(R.id.tvInmUso);
        ivInmFoto = root.findViewById(R.id.ivInmFoto);
        cbInmDisponible = root.findViewById(R.id.cbInmDisponible);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InmuebleViewModel.class);
        mViewModel.getMutable().observe(getViewLifecycleOwner(), inmueble -> {
            Glide.with(requireContext())
                    .load(inmueble.getImagen())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivInmFoto);
            tvInmDireccion.setText(inmueble.getDireccion());
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
            tvInmPrecio.setText(format.format(inmueble.getPrecio()));
            tvInmTipo.setText(inmueble.getTipo());
            tvInmAmbientes.setText(inmueble.getAmbientes() + "");
            tvInmUso.setText(inmueble.getUso());
            cbInmDisponible.setActivated(inmueble.isEstado());
        });
        if (getArguments() != null)
            mViewModel.cargarDatos(getArguments());
    }

}