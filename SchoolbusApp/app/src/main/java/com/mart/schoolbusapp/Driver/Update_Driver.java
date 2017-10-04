package com.mart.schoolbusapp.Driver;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.mart.schoolbusapp.Driver.Model_Driver.Data_Driver;
import com.mart.schoolbusapp.Driver.Model_Driver.Model_Driver;
import com.mart.schoolbusapp.Login.Login_Driver;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;


/**
 * Created by Mart_ on 30/11/2559.
 */

public class Update_Driver extends Activity implements View.OnClickListener {

    private Button btn_upadate;
    private Data_Driver driver;

    private EditText edt_id_driver;
    private EditText edt_name_driver;
    private EditText edt_tel_driver;
    private EditText edt_email_driver;
    private EditText edt_password_driver;

    private TextView tv_time_morning;
    private Button pickTimeM;
    private String morning;

    private TextView tv_time_evening;
    private Button pickTimeE;

    private int pHour;
    private int pMinute;
    static final int TIME_DIALOG_IDM = 0;
    static final int TIME_DIALOG_IDE = 1;

    private EditText edt_car_regis_driver;

    private TextView tv_name_driver;

    private TimePickerDialog.OnTimeSetListener mTimeSetListenerM =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
//                    updateDisplayM();
//                    updateDisplayE();
                    //displayToast();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    pHour = hourOfDay;
                    pMinute = minute;
//                    updateDisplayM();
//                    updateDisplayE();
                    //displayToast();
                }
            };

    private void updateDisplayM() {
        tv_time_morning.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));

        morning = tv_time_morning.getText().toString();
        Log.i("Time_morning",morning);
    }

    private void updateDisplayE() {
        tv_time_evening.setText(
                new StringBuilder()
                        .append(pad(pHour)).append(":")
                        .append(pad(pMinute)));
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_driver);

        driver = getIntent().getExtras().getParcelable("D");

        tv_name_driver = (TextView)findViewById(R.id.tv1_driver_xxx);
        tv_name_driver.setText(driver.getName_driver());

//        edt_id_parent = (EditText)findViewById(R.id.EDT_parent_id);
//        final int id_parent = parent.getId_parent();
//        edt_id_parent.setText(id_parent+"");
//        Log.i("ID"," : "+id_parent);

        edt_id_driver = (EditText)findViewById(R.id.EDT_driver_id);
        final  int id_driver = driver.getId_driver();
        edt_id_driver.setText(id_driver+"");

        edt_name_driver = (EditText)findViewById(R.id.EDT_driver_name);
        final String name_driver = driver.getName_driver();
        edt_name_driver.setText(name_driver);

        edt_tel_driver = (EditText)findViewById(R.id.EDT_driver_tel);
        final String tel_driver = driver.getTel_driver();
        edt_tel_driver.setText(tel_driver);

        edt_email_driver = (EditText)findViewById(R.id.EDT_driver_email);
        final String email_driver = driver.getEmail_driver();
        edt_email_driver.setText(email_driver);

        edt_password_driver = (EditText)findViewById(R.id.EDT_driver_password);
//        final String password_driver = driver.getPassword_driver();
//        edt_password_driver.setText(password_driver);

        tv_time_morning = (TextView)findViewById(R.id.timeDisplayM);
        //final String time_morning = driver.getTime_morning_driver();
        //tv_time_morning.setText(time_morning);

            pickTimeM = (Button) findViewById(R.id.pickTimeM);
            pickTimeM.setOnClickListener(this);

        tv_time_evening = (TextView)findViewById(R.id.timeDisplayE);
        //final String time_evening = driver.getTime_evening_driver();
        //tv_time_morning.setText(time_evening);
        //Log.i("Time_Evening",time_evening);

            pickTimeE = (Button) findViewById(R.id.pickTimeE);
            pickTimeE.setOnClickListener(this);

        edt_car_regis_driver = (EditText)findViewById(R.id.EDT_driver_carregis);
        final String carregis_driver = driver.getCar_registration();
        edt_car_regis_driver.setText(carregis_driver);
        //Log.i("Car",carregis_driver);

        btn_upadate = (Button)findViewById(R.id.btn_driver_update);
        btn_upadate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id_d = Integer.parseInt(edt_id_driver.getText().toString());
                String name_d = edt_name_driver.getText().toString();
                String tel_d = edt_tel_driver.getText().toString();
                String email_d = edt_email_driver.getText().toString();
                String password_d = edt_password_driver.getText().toString();
                String morning_d = tv_time_morning.getText().toString();
                String evening_d = tv_time_evening.getText().toString();
                String car_d = edt_car_regis_driver.getText().toString();

                Intent aIntent = new Intent(getApplication(), Login_Driver.class);

                aIntent.putExtra("id_driver",id_d);
                aIntent.putExtra("name_driver",name_d);
                aIntent.putExtra("tel_driver",tel_d);
                aIntent.putExtra("email_driver",email_d);
                aIntent.putExtra("password_driver",password_d);
                aIntent.putExtra("timestart_morning",morning_d);
                aIntent.putExtra("timestart_evening",evening_d);
                aIntent.putExtra("car_registration",car_d);

//                ServerConnecter connecter = new ServerConnecter();
//                connecter.connect8("update_driver.php",true,false,new Model_Driver(car_d,  email_d,  id_d,  name_d,  password_d,  tel_d,  morning_d,  evening_d));
//
//                Log.i("ALL ",""+id_d+" "+name_d+" "+tel_d+" "+email_d+" "+password_d+" "+car_d);

                ServerConnecter connecter = new ServerConnecter();
                connecter.connect8("update_driver.php",true,false,new Model_Driver(car_d,email_d,id_d,name_d,password_d,tel_d,morning_d,evening_d));

                Log.i("ALL ",""+id_d+" "+name_d+" "+tel_d+" "+email_d+" "+password_d+" "+car_d);
                startActivity(aIntent);

            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_IDM :
                return new TimePickerDialog(this,mTimeSetListenerM, pHour, pMinute, false);
            case TIME_DIALOG_IDE:
                return new TimePickerDialog(this,mTimeSetListener, pHour, pMinute, false);

        }
        return null;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.pickTimeM) {
            showDialog(TIME_DIALOG_IDM);
            updateDisplayM();
        }

        if (v.getId() == R.id.pickTimeE) {
            showDialog(TIME_DIALOG_IDE);
            updateDisplayE();
        }
    }


}

