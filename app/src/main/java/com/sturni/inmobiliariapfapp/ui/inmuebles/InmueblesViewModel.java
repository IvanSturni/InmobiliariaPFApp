package com.sturni.inmobiliariapfapp.ui.inmuebles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.request.ApiClient;

import java.util.ArrayList;

public class InmueblesViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;

    public LiveData<ArrayList<Inmueble>> obtenerInmueblesMutable(){
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void leer(){
        ArrayList<Inmueble> inmuebles = ApiClient.getApi().obtnerPropiedades();
        this.inmuebles.setValue(inmuebles);
    }
}