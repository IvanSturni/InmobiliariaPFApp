package com.sturni.inmobiliariapfapp.ui.compartido;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

abstract public class BaseViewModel<T> extends ViewModel {
    protected MutableLiveData<T> mutable;

    public LiveData<T> getMutable() {
        if (mutable == null) {
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }

    abstract public void cargarDatos(Bundle bundle);
}