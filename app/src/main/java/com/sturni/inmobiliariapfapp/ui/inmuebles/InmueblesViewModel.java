package com.sturni.inmobiliariapfapp.ui.inmuebles;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.request.ApiClient;
import com.sturni.inmobiliariapfapp.ui.compartido.BaseViewModel;

import java.util.ArrayList;

public class InmueblesViewModel extends BaseViewModel<ArrayList<Inmueble>> {
    @Override
    public void cargarDatos(@Nullable Bundle bundle) {
        ArrayList<Inmueble> inmuebles = ApiClient.getApi().obtnerPropiedades();
        mutable.setValue(inmuebles);
    }
}