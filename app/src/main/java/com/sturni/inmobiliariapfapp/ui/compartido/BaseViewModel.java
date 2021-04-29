package com.sturni.inmobiliariapfapp.ui.compartido;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.request.ApiClient;

abstract public class BaseViewModel<T> extends ViewModel {
    protected MutableLiveData<T> mutable;
    protected final ApiClient api = ApiClient.getApi();

    public LiveData<T> getMutable() {
        if (mutable == null) {
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }

    abstract public void cargarDatos(@Nullable Bundle bundle);
}