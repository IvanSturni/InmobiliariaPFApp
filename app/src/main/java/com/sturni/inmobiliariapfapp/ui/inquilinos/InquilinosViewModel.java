package com.sturni.inmobiliariapfapp.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.request.ApiClient;

import java.util.ArrayList;

public class InquilinosViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;

    public LiveData<ArrayList<Inmueble>> obtenerInmueblesMutable(){
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void leer(){
        ArrayList<Inmueble> inmuebles = ApiClient.getApi().obtenerPropiedadesAlquiladas();
        this.inmuebles.setValue(inmuebles);
    }
}