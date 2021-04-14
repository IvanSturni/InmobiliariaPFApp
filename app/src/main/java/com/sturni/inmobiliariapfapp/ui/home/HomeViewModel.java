package com.sturni.inmobiliariapfapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.request.ApiClient;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ejemplo de obtener información en HomeViewModel: " + ApiClient.getApi().obtenerUsuarioActual().getNombre());
    }

    public LiveData<String> getText() {
        return mText;
    }
}