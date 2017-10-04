package com.mart.schoolbusapp.Alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.mart.schoolbusapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mart_ on 13/1/2560.
 */

public class Alarm_Activity extends Activity {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int hr_mn = 0;
    private int min_mn = 50;

    private int hr_en = 0;
    private int min_en = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.need);

        Calendar calendar_mn = Calendar.getInstance();
        Calendar calendar_en = Calendar.getInstance();
        Log.i("Now ",""+sdf.format(calendar_mn.getTime()));

        calendar_mn.set(Calendar.HOUR_OF_DAY, hr_mn);
        calendar_mn.set(Calendar.MINUTE, min_mn);
        calendar_mn.set(Calendar.SECOND,0 );

        calendar_en.set(Calendar.HOUR_OF_DAY, hr_en);
        calendar_en.set(Calendar.MINUTE, min_en);
        calendar_en.set(Calendar.SECOND,0 );

        Intent myIntent = new Intent(Alarm_Activity.this,MyReceiver.class);
        PendingIntent pdi_mn = PendingIntent.getBroadcast(Alarm_Activity.this, 0, myIntent,0);
        PendingIntent pdi_en = PendingIntent.getBroadcast(Alarm_Activity.this, 2, myIntent,0);

        Log.i("1) MN ",""+sdf.format(calendar_mn.getTime()));
        Log.i("2) EN ",""+sdf.format(calendar_en.getTime()));

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, calendar_mn.getTimeInMillis(), pdi_mn);
        alarmManager.set(AlarmManager.RTC, calendar_en.getTimeInMillis(), pdi_en);

    }
}
