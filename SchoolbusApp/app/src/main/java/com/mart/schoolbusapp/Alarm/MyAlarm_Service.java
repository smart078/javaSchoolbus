package com.mart.schoolbusapp.Alarm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.mart.schoolbusapp.Need;
import com.mart.schoolbusapp.Need_EN;
import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 13/1/2560.
 */

public class MyAlarm_Service extends Service {

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Log.i("startID",""+startId);

        String msg_mn = "Do you need to get School bus in Morning ?";
        String msg_en = "Do you need to get School bus in Evening ?";

        if (startId==1){

            NotificationManager mManager_mn = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent pending_mn = PendingIntent.getActivity(this, 0, new Intent(this, Need.class), 0);

            NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(this)
                    .setContentTitle("Lasalle School Bus ").setSmallIcon(R.mipmap.ic_launcher)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(msg_mn))
                    .setContentText(msg_mn);

            alamNotificationBuilder.setContentIntent(pending_mn);
            mManager_mn.notify(1, alamNotificationBuilder.build());

        }else if (startId==2){
            NotificationManager mManager_en = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent pending_en = PendingIntent.getActivity(this, 2, new Intent(this, Need_EN.class), 0);

            NotificationCompat.Builder noti_en = new NotificationCompat.Builder(this)
                    .setContentTitle("Lasalle School Bus").setSmallIcon(R.mipmap.ic_launcher)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(msg_en))
                    .setContentText(msg_en);

            noti_en.setContentIntent(pending_en);
            mManager_en.notify(2, noti_en.build());
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
