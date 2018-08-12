package com.studioabir.fcmphp.fcmphp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FcmMessagingService extends FirebaseMessagingService{


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent,PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder notificationbuilder = new Notification.Builder(this);
        notificationbuilder.setContentTitle(title);
        notificationbuilder.setContentText(message);
        notificationbuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationbuilder.setAutoCancel(true);
        notificationbuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationbuilder.build());




    }
}