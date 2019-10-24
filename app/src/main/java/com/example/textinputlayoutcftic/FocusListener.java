package com.example.textinputlayoutcftic;

import android.app.Activity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by vale on 6/06/16.
 */
public class FocusListener implements View.OnFocusChangeListener {

    private Activity actividad;

    public FocusListener (Activity activity)
    {
        this.actividad = activity;
    }

    /**
     * Idealmente, este método debería ir en un clase Util Validar o algo parecido
     */
    private boolean emailValido (String email)
    {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {

            EditText cajatextomail = (EditText)v;
            String mailintroducido = cajatextomail.getText().toString();

            if (!emailValido (mailintroducido))
            {
                TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcajamail);
                wrapmail.setError("Mail Incorrecto");
            }
        }
    }
}
