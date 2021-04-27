package com.sturni.inmobiliariapfapp.ui.inquilinos;

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

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel mViewModel;
    private RecyclerView recView;

    public static InquilinosFragment newInstance() {
        return new InquilinosFragment();
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
        mViewModel = new ViewModelProvider(this).get(InquilinosViewModel.class);
        mViewModel.obtenerInmueblesMutable().observe(getViewLifecycleOwner(), inmuebles -> {
            RecyclerView.Adapter adapter = new InquilinoAdapter(getContext(),inmuebles);
            recView.setAdapter(adapter);
            recView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
        mViewModel.leer();
    }

}