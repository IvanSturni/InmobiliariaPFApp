package com.sturni.inmobiliariapfapp.ui.inmuebles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;

import java.util.ArrayList;

public class InmuebleViewModel extends ViewModel {
    private MutableLiveData<Inmueble> inmueble;

    public LiveData<Inmueble> getInmuebleMutable() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }



}