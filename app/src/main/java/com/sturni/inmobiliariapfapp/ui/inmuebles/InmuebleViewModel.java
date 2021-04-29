package com.sturni.inmobiliariapfapp.ui.inmuebles;

import android.os.Bundle;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.ui.compartido.BaseViewModel;

public class InmuebleViewModel extends BaseViewModel<Inmueble> {

    @Override
    public void cargarDatos(Bundle bundle) {
        mutable.setValue((Inmueble) bundle.getSerializable("Inmueble"));
    }
}