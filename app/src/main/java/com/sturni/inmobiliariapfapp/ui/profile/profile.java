package com.sturni.inmobiliariapfapp.ui.profile;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sturni.inmobiliariapfapp.R;
import com.sturni.inmobiliariapfapp.modelo.Propietario;

public class profile extends Fragment {

    private ProfileViewModel profileViewModel;
    private EditText dni_et, name_et, lastname_et, email_et, phone_et, password_et, code_et;

    public static profile newInstance() {
        return new profile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        initComponents(root);

        profileViewModel.getPropietarioMutable().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                dni_et.setText(propietario.getDni().toString());
                name_et.setText(propietario.getNombre().toString());
                lastname_et.setText(propietario.getApellido());
                email_et.setText(propietario.getEmail());
                phone_et.setText(propietario.getTelefono());
                password_et.setText(propietario.getContraseña());
            }
        });

        profileViewModel.loadProfile();

        return root;


    }

    private void initComponents(View root){
        code_et = root.findViewById(R.id.code_et);
        dni_et = root.findViewById(R.id.dni_et);
        name_et = root.findViewById(R.id.name_et);
        lastname_et = root.findViewById(R.id.lastname_et);
        email_et = root.findViewById(R.id.email_et);
        phone_et = root.findViewById(R.id.phone_et);
        password_et = root.findViewById(R.id.password_et);

    }

}