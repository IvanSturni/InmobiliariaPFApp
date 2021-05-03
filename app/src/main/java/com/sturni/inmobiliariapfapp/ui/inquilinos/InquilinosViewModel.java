package com.sturni.inmobiliariapfapp.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.modelo.Inquilino;
import com.sturni.inmobiliariapfapp.request.ApiClient;

import java.util.ArrayList;

public class InquilinosViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<Inquilino> inquilinoMutableLiveData;

    public LiveData<ArrayList<Inmueble>> obtenerInmueblesMutable(){
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public LiveData<Inquilino> getInquilinoMutable(){
        if(inquilinoMutableLiveData == null){
            inquilinoMutableLiveData = new MutableLiveData<>();
        }

        return inquilinoMutableLiveData;
    }

    public void leer(){
        ArrayList<Inmueble> inmuebles = ApiClient.getApi().obtenerPropiedadesAlquiladas();
        this.inmuebles.setValue(inmuebles);
    }

    public void obtainInquilino(Inmueble inmueble){
        Inquilino inquilino = ApiClient.getApi().obtenerInquilino(inmueble);
        this.inquilinoMutableLiveData.setValue(inquilino);
    }
}