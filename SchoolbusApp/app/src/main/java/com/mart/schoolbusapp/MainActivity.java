package com.mart.schoolbusapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import static com.mart.schoolbusapp.Alarm_Reciver.*;

public class MainActivity extends Activity {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static MainActivity inst;
    private TextView alarmTextView;
    public int num = 0;


    public static MainActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        Log.d("Num", "is "+num);
//        if (){
//            dialog_need();
//            Log.d("Main", "dialog");
//        }

    }

    @TargetApi(Build.VERSION_CODES.N)
    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");

            java.util.Calendar calendar = java.util.Calendar.getInstance().getInstance();
            calendar.set(java.util.Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(java.util.Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
            Intent myIntent = new Intent(MainActivity.this, Alarm_Reciver.class);
            pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
            Log.d("MyActivity", "Pending Intent");
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            num = 1;
            Log.d("MyActivity", "alarm manager");



        } else {
            num=0;
            alarmManager.cancel(pendingIntent);
            setAlarmText("");
            Log.d("MyActivity", "Alarm Off");
        }
    }

    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }

    public  void dialog_need(){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setMessage("ระบุความต้องการในการใช้รถ");
        builder.setPositiveButton("ไม่ขึ้นรถรับส่งนักเรียน", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setNegativeButton("ขึ้นรถรับส่งนักเรียน", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            }
        });
        builder.show();
    }
}