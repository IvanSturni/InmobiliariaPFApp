package com.sturni.inmobiliariapfapp.ui.inmuebles;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Inmueble;

public class InmuebleFragment extends Fragment {

    private InmuebleViewModel mViewModel;

    public InmuebleFragment() {
    }

    public static InmuebleFragment newInstance(Inmueble inmueble) { return new InmuebleFragment(); }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inmueble_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InmuebleViewModel.class);
        Log.d("test", "onActivityCreated: " + ((Inmueble) getArguments().getSerializable("Inmueble")).getDireccion());

    }

}