package com.mart.schoolbusapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mart.schoolbusapp.Parent.Part_Parent;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 21/2/2560.
 */

public class Input_Number_OTP extends Activity implements View.OnClickListener {

    private EditText edt_input_otpNumber;
    private Button btn_inputOTP;
    private int id_parent;
    private int id_student;

    Data_OTP data_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_number_otp);

        btn_inputOTP = (Button)findViewById(R.id.btn_submit_number_otp);
        btn_inputOTP.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        edt_input_otpNumber = (EditText)findViewById(R.id.EDT_INPUT_NUMBER_OTP);
        String otp_Number = edt_input_otpNumber.getText().toString();

        ServerConnecter connecter = new ServerConnecter();
        String re = connecter.connect14("select_numberPhone_otp.php",true,true, new Model_Number_OTP(otp_Number));
        JSONArray arr = connecter.getResponseArray(re);
        Log.i("Login JSON", ""+arr);

        for(int i=0;i<arr.length();i++) {

            try {
                data_otp = new Data_OTP(arr.getJSONObject(i));
                id_parent = data_otp.getId_parent();
                id_student = data_otp.getId_student();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        Log.i(" ID_PARENT : "," " +id_parent);
        Log.i(" ID_STUDENT : "," " +id_student);

        if (arr != null && arr.length() > 0 ){

            Intent intent = new Intent(this, ListSTD_Activity.class);

            connecter.connect15("update_status_student.php",true,false, new Model_Update_StatusSTD_OTP(id_parent,id_student));

            startActivity(intent);

        }

    }
}
