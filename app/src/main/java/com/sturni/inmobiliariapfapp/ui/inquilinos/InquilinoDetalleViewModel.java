package com.sturni.inmobiliariapfapp.ui.inquilinos;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sturni.inmobiliariapfapp.modelo.Inquilino;
import com.sturni.inmobiliariapfapp.request.ApiClient;

public class InquilinoDetalleViewModel extends ViewModel {

    protected MutableLiveData<Inquilino> inquilinoMutableLiveData;

    public MutableLiveData<Inquilino> getInquilinoMutableLiveData(){
        if(inquilinoMutableLiveData == null){
            inquilinoMutableLiveData = new MutableLiveData<>();
        }

        return inquilinoMutableLiveData;
    }

    public void loadDetailInquilino(Inquilino inquilino){
        inquilinoMutableLiveData.setValue(inquilino);
    }

}