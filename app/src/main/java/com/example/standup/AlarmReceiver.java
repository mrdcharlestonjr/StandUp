package com.example.standup;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManager mNotificationManager;
    private static final String PRIMARY_NOTIFICATION_CHANNEL = "primary_notification_channel";
    private static final int CHANNEL_ID = 0;

    @Override
    public void onReceive(Context context, Intent intent) {

        mNotificationManager = (NotificationManager)(context.getSystemService(Context.NOTIFICATION_SERVICE));
        deliveryNotification(context);


    }

    private void deliveryNotification(Context context) {

        Intent contentIntent = new Intent(context,MainActivity.class);
        PendingIntent pendingContentIntent = PendingIntent.getActivity(context, CHANNEL_ID,contentIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,PRIMARY_NOTIFICATION_CHANNEL)


                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_stand_up)
                .setContentIntent(pendingContentIntent)
                .setContentTitle("Stand Up Alert")
                .setContentText("You should stand up and walk")
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        mNotificationManager.notify(CHANNEL_ID,builder.build());
    }
}
