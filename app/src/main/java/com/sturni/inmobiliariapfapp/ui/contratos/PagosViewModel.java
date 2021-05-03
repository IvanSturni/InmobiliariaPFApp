package com.sturni.inmobiliariapfapp.ui.contratos;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sturni.inmobiliariapfapp.modelo.Inmueble;
import com.sturni.inmobiliariapfapp.modelo.Pago;
import com.sturni.inmobiliariapfapp.ui.compartido.BaseViewModel;

import java.util.ArrayList;

public class PagosViewModel extends BaseViewModel<ArrayList<Pago>> {
    @Override
    public void cargarDatos(@Nullable Bundle bundle) {
        mutable.setValue(api.obtenerPagos(api.obtenerContratoVigente((Inmueble) bundle.getSerializable("Inmueble"))));
    }
}