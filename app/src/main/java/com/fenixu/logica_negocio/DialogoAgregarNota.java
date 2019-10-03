package com.fenixu.logica_negocio;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.fenixu.R;

public class DialogoAgregarNota extends AppCompatDialogFragment {

    private EditText nota;
    private EditText porcentaje;
    private DialogoCrearNotasListener dcml;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_agregar_nota, null);

        builder.setView(view)
                .setTitle("Agregar nota")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String notaR = nota.getText().toString();
                        String porcentajeR = porcentaje.getText().toString();
                        dcml.applyTexts(notaR, porcentajeR);
                    }
                });

        nota = view.findViewById(R.id.lista_nota);
        porcentaje = view.findViewById(R.id.lista_porcentaje);

        return builder.create();
    }

    @Override
    public void onAttach(Context contexto){
        super.onAttach(contexto);

        try {
            dcml = (DialogoCrearNotasListener)contexto;
        } catch (ClassCastException e) {
            throw new ClassCastException(contexto.toString() + "Error");
        }
    }

    public interface DialogoCrearNotasListener{
        void applyTexts(String nota, String porcentaje);
    }

}