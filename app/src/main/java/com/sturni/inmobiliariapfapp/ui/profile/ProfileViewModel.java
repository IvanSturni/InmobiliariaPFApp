package com.sturni.inmobiliariapfapp.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Propietario;
import com.sturni.inmobiliariapfapp.request.ApiClient;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<Propietario> propetarioMutable;
    private MutableLiveData<String> buttonEditMutable;

    public LiveData<Propietario> getPropietarioMutable(){
        if(propetarioMutable == null){
            propetarioMutable = new MutableLiveData<>();
        }
        return propetarioMutable;
    }

    public LiveData<String>  getButtonEditMutable(){
        if(buttonEditMutable == null){
            buttonEditMutable = new MutableLiveData<>();
        }
        return buttonEditMutable;
    }


    public void loadProfile(){
        ApiClient api = ApiClient.getApi();
        Propietario propietario = api.obtenerUsuarioActual();
        propetarioMutable.setValue(propietario);
    }

    public void saveProfile(Propietario prop){
        ApiClient api = ApiClient.getApi();
        api.actualizarPerfil(prop);
        propetarioMutable.setValue(prop);
    }

    public void toggleButton(Propietario prop){
        if(buttonEditMutable.getValue() == "Editar"){
            buttonEditMutable.setValue("Guardar");
        }else{
            buttonEditMutable.setValue("Editar");
            saveProfile(prop);
        }
    }
}