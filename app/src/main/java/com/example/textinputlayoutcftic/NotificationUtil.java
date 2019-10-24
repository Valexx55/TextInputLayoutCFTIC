package com.example.textinputlayoutcftic;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationUtil {

    //El id
    public static final String NOTIFICATION_CHANNEL_ID = "channel_id";

    //El nombre visible para el usuario en Ajustes
    public static final String CHANNEL_NAME = "Notification Channel";

    @TargetApi(26)
    private static NotificationChannel crearCanalNotificacion ()
    {
        NotificationChannel notificationChannel = null;



        notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);

        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(Color.GREEN);

        //Indicamos si la notificación será visible estando la pantalla bloqueada o no
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);



        return notificationChannel;
    }

    public static void lanzarNotificiacion(Context context) {

        Log.d("MENSAJE", "Lanzando notificación");
        NotificationCompat.Builder nb = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel nc = crearCanalNotificacion();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(nc);
            nb = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        } else {

            nb =  new NotificationCompat.Builder(context, null);

        }



        nb.setSmallIcon(R.drawable.ic_clip);
        nb.setContentTitle("BUENOS DÍAS");
        nb.setAutoCancel(true);
        nb.setDefaults(Notification.DEFAULT_ALL);
        nb.setContentText("Como no te voy a querer");
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.raja);
        nb.setLargeIcon(icon);

        Intent resultIntent = new Intent(context, MainActivity.class);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(context, 200, resultIntent, PendingIntent.FLAG_ONE_SHOT);

        nb.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(537, nb.build());//537
    }
}
