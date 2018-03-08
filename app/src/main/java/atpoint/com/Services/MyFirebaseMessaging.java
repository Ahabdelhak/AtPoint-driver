package atpoint.com.Services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import atpoint.com.Model.Notification;
import atpoint.com.R;

/**
 * Created by ah_abdelhak on 2/28/2018.
 */
public class MyFirebaseMessaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {

       if(remoteMessage.getNotification().getTitle().equals("Cancelled")) {
           //Handler because this is in main thread
           Handler handler = new Handler(Looper.getMainLooper());
           handler.post(new Runnable() {
               @Override
               public void run() {
                   Toast.makeText(MyFirebaseMessaging.this, "" + remoteMessage.getNotification().getBody(), Toast.LENGTH_SHORT).show();
               }
           });
       }
        else if(remoteMessage.getNotification().getTitle().equals("Arrived")) {

           ShowArrivedNotification(remoteMessage.getNotification().getBody());
       }


    }

    private void ShowArrivedNotification(String body) {
        //This notification show only for Api 25 and below // TODO: 3/4/2018 We will make Notification cahnnel to work for higher Api 25

        PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(),0,new Intent(),PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext());

        builder.setAutoCancel(true)
                .setDefaults(android.app.Notification.DEFAULT_LIGHTS | android.app.Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Arrived")
                .setContentText(body)
                .setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, builder.build());

    }
}
