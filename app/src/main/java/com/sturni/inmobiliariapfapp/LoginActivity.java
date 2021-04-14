package com.sturni.inmobiliariapfapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsuario, etPassword;
    private Button btLogin;
    private LoginActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);
        inicializarVista();

        vm.getMensajeMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("Advertencia")
                        .setMessage(mensaje)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });

        vm.getExitoMutable().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean exito) {
                if (exito) {
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    private void inicializarVista() {
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContrasenia);
        btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.verificarDatos(etUsuario.getText().toString(),etPassword.getText().toString());
            }
        });
    }


}