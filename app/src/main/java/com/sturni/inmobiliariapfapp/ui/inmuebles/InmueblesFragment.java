package com.sturni.inmobiliariapfapp.ui.inmuebles;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sturni.inmobiliariapfapp.R;

public class InmueblesFragment extends Fragment {

    private InmueblesViewModel mViewModel;
    private RecyclerView recView;

    public static InmueblesFragment newInstance() {
        return new InmueblesFragment();
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
        mViewModel = new ViewModelProvider(this).get(InmueblesViewModel.class);
        mViewModel.getMutable().observe(getViewLifecycleOwner(), inmuebles -> {
            RecyclerView.Adapter adapter = new InmuebleAdapter(getContext(),inmuebles);
            recView.setAdapter(adapter);
            recView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
        mViewModel.cargarDatos(null);
    }

}