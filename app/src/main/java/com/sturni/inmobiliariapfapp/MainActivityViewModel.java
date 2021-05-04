package com.sturni.inmobiliariapfapp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sturni.inmobiliariapfapp.modelo.Propietario;
import com.sturni.inmobiliariapfapp.ui.compartido.BaseViewModel;

public class MainActivityViewModel extends BaseViewModel<Propietario> {
    @Override
    public void cargarDatos(@Nullable Bundle bundle) {
        mutable.setValue(api.obtenerUsuarioActual());
    }
}
