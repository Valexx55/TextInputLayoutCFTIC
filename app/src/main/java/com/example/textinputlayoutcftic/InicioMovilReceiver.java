package com.example.textinputlayoutcftic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InicioMovilReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d("MIAPP", "Se ha iniciado el teléfono");
        //context.startActivity(new Intent(context, MainActivity.class));
        NotificationUtil.lanzarNotificiacion(context);
        programarAlarma(context);


    }

    private void programarAlarma (Context context)
    {
        Calendar calendar_actual = Calendar.getInstance();

        long tiempo = calendar_actual.getTimeInMillis() + 6000; //en 1 min, 60 mil ms, saltará la alarma

        Intent intentAlarm = new Intent(context, AlarmaReceiver.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 55, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, tiempo, pi);//TIempo, No es el tiempo que falta. Es el tiempo expresado en milisegundos equivalente a la fecha y hora del omento en que se quiere ejecutar


        SimpleDateFormat dateformatter = new SimpleDateFormat("E dd/MM/yyyy 'a las' hh:mm:ss");

        String mensaje = "Alarma programada para "+ dateformatter.format(tiempo);
        Log.d("MIAPP", mensaje);


        Toast.makeText(context,mensaje, Toast.LENGTH_LONG ).show();

    }
}
