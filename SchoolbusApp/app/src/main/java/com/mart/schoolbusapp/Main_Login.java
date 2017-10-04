package com.mart.schoolbusapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mart.schoolbusapp.Driver.Model_Driver.Data_Driver;
import com.mart.schoolbusapp.Driver.Part_Driver;
import com.mart.schoolbusapp.Model_Login.Model_Login_driver;
import com.mart.schoolbusapp.Model_Login.Model_Login_parent;
import com.mart.schoolbusapp.Model_Login.Model_Login_teacher;
import com.mart.schoolbusapp.Parent.Data_parent;
import com.mart.schoolbusapp.Parent.Part_Parent;
import com.mart.schoolbusapp.Server.ServerConnecter;
import com.mart.schoolbusapp.Teacher.Data_Teacher;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 23/12/2559.
 */

public class Main_Login extends Activity implements View.OnClickListener {

    private Button btn_log_user_all;
    private Data_Driver driver;
    private Data_Teacher teacher;
    private Data_parent parent;
    private TextView username;

    private JSONArray arr_DV;
    private JSONArray arr_TC;
    private JSONArray arr_PR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        new CountDownTimer(2000, 1000) {
            public void onFinish() {

                if (arr_DV != null && arr_DV.length() > 0) {
                    Intent intent = new Intent(getApplicationContext(), Part_Driver.class);
                    intent.putExtra("DRIVER", driver);
                    startActivity(intent);
                }else if (arr_TC != null && arr_TC.length() > 0 ){
                    Intent intent = new Intent(getApplicationContext(), Menu_Teacher.class);
                    intent.putExtra("TEACHER", teacher);
                    startActivity(intent);
                }else if (arr_PR != null && arr_PR.length() > 0) {
                        Intent intent = new Intent(getApplicationContext(), Part_Parent.class);
                        intent.putExtra("PARENT", parent);
                        startActivity(intent);
                }

            }

            public void onTick(long millisUntilFinished) {

                username = (TextView) findViewById(R.id.number);
                    TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                username.setText(manager.getLine1Number());
                    String user_all = username.getText().toString();

                if (user_all != null) {
                    Log.i("Check driver", "");
                    ServerConnecter connecter_DV = new ServerConnecter();
                    String re_DV = connecter_DV.connect3("select_login_driver.php", true, true, new Model_Login_driver(user_all));
                    arr_DV = connecter_DV.getResponseArray(re_DV);
                    Log.i("Login JSON DV", "" + arr_DV);
                    //Toast.makeText(this,"RESULT : "+arr_DV,Toast.LENGTH_SHORT).show();

                    if (arr_DV != null && arr_DV.length() > 0 ){
                        for (int i = 0; i < arr_DV.length(); i++) {

                            Log.i("driver", ""+i);

                            try {
                                driver = new Data_Driver(arr_DV.getJSONObject(i));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }else {
                        Log.i("Check teacher", "");
                        ServerConnecter connecter_TC = new ServerConnecter();
                        String re_TC = connecter_TC.connect4("select_login_teacher.php", true, true, new Model_Login_teacher(user_all));
                        arr_TC = connecter_TC.getResponseArray(re_TC);
                        Log.i("Login JSON TC", "" + arr_TC);
                        //Toast.makeText(this,"RESULT : "+arr_TC,Toast.LENGTH_SHORT).show();
                        if (arr_TC != null && arr_TC.length() > 0) {
                            for (int i = 0; i < arr_TC.length(); i++) {

                                Log.i("Teacher", ""+i);

                                try {
                                    teacher = new Data_Teacher(arr_TC.getJSONObject(i));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }else {
                            ServerConnecter connecter_PR = new ServerConnecter();
                            String re_PR = connecter_PR.connect2("select_login_parent.php",true,true,new Model_Login_parent(user_all));
                            arr_PR = connecter_PR.getResponseArray(re_PR);
                            Log.i("Login JSON PR", "" + arr_PR);
                            //Toast.makeText(this, "RESULT : " + arr_PR, Toast.LENGTH_SHORT).show();

                            for (int i = 0; i < arr_PR.length(); i++) {

                                try {
                                    parent = new  Data_parent(arr_PR.getJSONObject(i));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }.start();



//        username = (TextView)findViewById(R.id.number);
//
//        TelephonyManager manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//
//        username.setText(manager.getLine1Number());
//
//        String user_all = username.getText().toString();
//
//        btn_log_user_all = (Button)findViewById(R.id.btnLog_All);
//        btn_log_user_all.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


//        EditText username = (EditText)findViewById(R.id.USER_ALL);
        //String user_all = username.getText().toString();

//        EditText password = (EditText)findViewById(R.id.PASSWORD_ALL);
//        String pass_all = password.getText().toString();
//
//            if (user_all != null && pass_all != null){
//                ServerConnecter connecter_DV = new ServerConnecter();
//                String re_DV = connecter_DV.connect3("select_login_driver.php",true,true,new Model_Login_driver(user_all,pass_all));
//                JSONArray arr_DV = connecter_DV.getResponseArray(re_DV);
//                Log.i("Login JSON DV", ""+arr_DV);
//                //Toast.makeText(this,"RESULT : "+arr_DV,Toast.LENGTH_SHORT).show();
//
//                for(int i=0;i<arr_DV.length();i++) {
//
//                    try {
//                        driver = new Data_Driver(arr_DV.getJSONObject(i));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            if (arr_DV != null && arr_DV.length() > 0 ){
//                Intent intent = new Intent(this, Part_Driver.class);
//                intent.putExtra("DRIVER", driver);
//                startActivity(intent);
//
//            }else {
//                ServerConnecter connecter_TC = new ServerConnecter();
//                String re_TC = connecter_TC.connect4("select_login_teacher.php",true,true,new Model_Login_teacher(user_all,pass_all));
//                JSONArray arr_TC = connecter_TC.getResponseArray(re_TC);
//                Log.i("Login JSON TC", ""+arr_TC);
//                //Toast.makeText(this,"RESULT : "+arr_TC,Toast.LENGTH_SHORT).show();
//
//                for(int i=0;i<arr_TC.length();i++) {
//
//                    try {
//                        teacher = new Data_Teacher(arr_TC.getJSONObject(i));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                if (arr_TC != null && arr_TC.length() > 0 ){
//                    Intent intent = new Intent(this, Menu_Teacher.class);
//                    intent.putExtra("TEACHER", teacher);
//                    startActivity(intent);
//                }else{
//                    ServerConnecter connecter_PR = new ServerConnecter();
//                    String re_PR = connecter_PR.connect2("select_login_parent.php",true,true,new Model_Login_parent(user_all,pass_all));
//                    JSONArray arr_PR = connecter_PR.getResponseArray(re_PR);
//                    Log.i("Login JSON PR", "" + arr_PR);
//                    //Toast.makeText(this, "RESULT : " + arr_PR, Toast.LENGTH_SHORT).show();
//
//                    for (int i = 0; i < arr_PR.length(); i++) {
//
//                        try {
//                            parent = new  Data_parent(arr_PR.getJSONObject(i));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    if (arr_PR != null && arr_PR.length() > 0) {
//                        Intent intent = new Intent(this, Part_Parent.class);
//                        intent.putExtra("PARENT", parent);
//                        startActivity(intent);
//                    }
//                }
//            }
//        }
//    }
    }
}
