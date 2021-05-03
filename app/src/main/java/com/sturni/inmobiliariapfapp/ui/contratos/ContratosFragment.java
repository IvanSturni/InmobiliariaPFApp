package com.sturni.inmobiliariapfapp.ui.contratos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sturni.inmobiliariapfapp.R;

public class ContratosFragment extends Fragment {

    private ContratosViewModel mViewModel;
    private RecyclerView recView;

    public static ContratosFragment newInstance() {
        return new ContratosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inmuebles_fragment, container, false);
        inicializarVista(root);
        return root;
    }

    private void inicializarVista(View root) {
        recView = root.findViewById(R.id.recView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContratosViewModel.class);
        mViewModel.getMutable().observe(getViewLifecycleOwner(), contratos -> {
            RecyclerView.Adapter adapter = new ContratoAdapter(getContext(),contratos);
            recView.setAdapter(adapter);
            recView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
        mViewModel.cargarDatos(null);
    }

}