package com.mart.schoolbusapp.Alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mart.schoolbusapp.Alarm.MyAlarm_Service;

/**
 * Created by Mart_ on 13/1/2560.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service1 = new Intent(context, MyAlarm_Service.class);
        context.startService(service1);

    }
}
