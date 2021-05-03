package com.sturni.inmobiliariapfapp.ui.contratos;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sturni.inmobiliariapfapp.modelo.Contrato;
import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.request.ApiClient;
import com.sturni.inmobiliariapfapp.ui.compartido.BaseViewModel;

import java.util.ArrayList;

public class ContratosViewModel extends BaseViewModel<ArrayList<Inmueble>> {
    @Override
    public void cargarDatos(@Nullable Bundle bundle) {
        ArrayList<Inmueble> contratos = ApiClient.getApi().obtenerPropiedadesAlquiladas();
        mutable.setValue(contratos);
    }
}