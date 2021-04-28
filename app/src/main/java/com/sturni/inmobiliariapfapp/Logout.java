package com.sturni.inmobiliariapfapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Logout {
    public static void salir(Context context) {
        AlertDialog.Builder dialogSalir = new AlertDialog.Builder(context);
        dialogSalir.setTitle("Salir");
        dialogSalir.setMessage("Desea salir de la cuenta?");

        dialogSalir.setPositiveButton("Sí", (dialogInterface, i) -> System.exit(0))
                .setNegativeButton("No", (dialog, i) -> {})
                .show();
    }
}
