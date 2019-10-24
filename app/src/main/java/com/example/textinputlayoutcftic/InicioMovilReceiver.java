package com.example.textinputlayoutcftic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class InicioMovilReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d("MIAPP", "Se ha iniciado el teléfono");
        //context.startActivity(new Intent(context, MainActivity.class));
        NotificationUtil.lanzarNotificiacion(context);
    }
}
