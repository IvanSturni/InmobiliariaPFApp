package com.sturni.inmobiliariapfapp.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Inquilino;

public class InquilinoDetalleFragment extends Fragment {

    private InquilinoDetalleViewModel mViewModel;
    private Inquilino inquilinoActual;
    private TextView code_tv, name_tv, lastname_tv, dni_tv, email_tv, phone_tv, garanty_tv, garantyPhone_tv;
    private TextView code_label, name_label, lastname_label, dni_label, email_label, phone_label, garanty_tv, garantyPhone_tv;
    public InquilinoDetalleFragment() {}

    public static InquilinoDetalleFragment newInstance() {
        return new InquilinoDetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(InquilinoDetalleViewModel.class);
        View root = inflater.inflate(R.layout.inquilino_detalle_fragment, container, false);

        initView(root);

        inquilinoActual = (Inquilino) getArguments().getSerializable("inquilino");

        mViewModel.getInquilinoMutableLiveData().observe(getViewLifecycleOwner(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                inquilinoActual = inquilino;

                code_tv.setText(""+inquilinoActual.getIdInquilino());
                name_tv.setText(inquilinoActual.getNombre());
                lastname_tv.setText(inquilinoActual.getApellido());
                dni_tv.setText(""+inquilinoActual.getDNI());
                email_tv.setText(inquilinoActual.getEmail());
                phone_tv.setText(inquilinoActual.getTelefono());
                garanty_tv.setText(inquilinoActual.getNombreGarante());
                garantyPhone_tv.setText(inquilinoActual.getTelefonoGarante());
            }
        });

        mViewModel.loadDetailInquilino(inquilinoActual);

        return root;
    }

    private void initView(View root){
        code_tv = root.findViewById(R.id.code_tv);
        name_tv = root.findViewById(R.id.name_tv);
        lastname_tv = root.findViewById(R.id.lastname_tv);
        dni_tv = root.findViewById(R.id.dni_tv);
        email_tv = root.findViewById(R.id.email_tv);
        phone_tv = root.findViewById(R.id.phone_tv);
        garanty_tv = root.findViewById(R.id.garanty_tv);
        garantyPhone_tv = root.findViewById(R.id.garanty_phone_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InquilinoDetalleViewModel.class);
        mViewModel.getInquilinoMutableLiveData().observe(getViewLifecycleOwner(), inquilino  -> {
            code_tv.setText(""+inquilino.getIdInquilino());
            name_tv.setText(inquilino.getNombre());
            lastname_tv.setText(inquilino.getApellido());
            dni_tv.setText(""+inquilino.getDNI());
            email_tv.setText(inquilino.getEmail());
            phone_tv.setText(inquilino.getTelefono());
            garanty_tv.setText(inquilino.getNombreGarante());
            garantyPhone_tv.setText(inquilino.getTelefonoGarante());
        });

    }

}