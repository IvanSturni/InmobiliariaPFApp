package com.sturni.inmobiliariapfapp.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Propietario;
import com.sturni.inmobiliariapfapp.request.ApiClient;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<Propietario> propetarioMutable;

    public LiveData<Propietario> getPropietarioMutable(){
        if(propetarioMutable == null){
            propetarioMutable = new MutableLiveData<>();
        }
        return propetarioMutable;
    }

    public void loadProfile(){
        ApiClient api = ApiClient.getApi();
        Propietario propietario = api.obtenerUsuarioActual();
        propetarioMutable.setValue(propietario);
    }
}