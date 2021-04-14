package com.sturni.inmobiliariapfapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.request.ApiClient;

public class LoginActivityViewModel extends ViewModel {
    private MutableLiveData<String> mensaje;
    private MutableLiveData<Boolean> exito;

    public LiveData<String> getMensajeMutable() {
        if (mensaje==null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public LiveData<Boolean> getExitoMutable() {
        if (exito==null) {
            exito = new MutableLiveData<>();
        }
        return exito;
    }

    public void verificarDatos(String usuario, String pass){
        if (usuario != null && pass != null && !usuario.isEmpty() && !pass.isEmpty()) {
            ApiClient api = ApiClient.getApi();
            // Si no recibe un usuario, mostrar error, si recibe, decir que fue un éxito
            if (api.login(usuario, pass) == null) {
                mensaje.setValue("Usuario y/o contraseña incorrectos.");
            } else {
                exito.setValue(true);
            }
        } else {
            mensaje.setValue("Por favor complete los campos.");
        }
    }

}
