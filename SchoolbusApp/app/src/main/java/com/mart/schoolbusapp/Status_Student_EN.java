package com.mart.schoolbusapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mart.schoolbusapp.History_H_Person.History_Person;
import com.mart.schoolbusapp.ListSTD.EntityModelListSTD;
import com.mart.schoolbusapp.ListSTD.ListSTDModel;
import com.mart.schoolbusapp.Login.Login_Teacher;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 7/12/2559.
 */

public class Status_Student_EN extends Activity {

    private String id_p;
    private TextView id_std;
    private TextView std_name;
    private TextView std_edu;
    private TextView parent_name;
    private TextView parent_tel;
    private ListSTDModel listSTDModel;
    private Data_Count_Number data_count_number;

    private Button button_history_en;
    private Button button_number_otp_EN;
    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_student);


        id_std = (TextView)findViewById(R.id.TVCODE2);
        id_std.setVisibility(View.GONE);
        std_name = (TextView)findViewById(R.id.std_name);
        std_edu = (TextView)findViewById(R.id.std_edu);
        parent_name = (TextView)findViewById(R.id.parent_name);
        parent_tel = (TextView)findViewById(R.id.parent_tel);

        listSTDModel = getIntent().getExtras().getParcelable("DATA");

        id_p = listSTDModel.getId_parent();
        id_std.setText(listSTDModel.getId_std());
        std_name.setText(listSTDModel.getStd_name());
        std_edu.setText(listSTDModel.getStd_edu());
        parent_name.setText(listSTDModel.getParent_name());
        parent_tel.setText(listSTDModel.getParent_tel());

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int In_bus = 1;

                Intent intent = new Intent(getApplicationContext(),ListSTD_Activity.class);
                int id = Integer.parseInt(listSTDModel.getId_std());

                intent.putExtra("id_std",id);
                intent.putExtra("status",In_bus);

                Log.i("ID ",""+id);
                Log.i("INBUS ",""+In_bus);

                ServerConnecter connector = new ServerConnecter();
                connector.connect("update_listSTD_evening.php", true, false, new EntityModelListSTD(id,In_bus));

                startActivity(intent);
            }
        });

        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Dropped = 2;
                Intent intent = new Intent(getApplicationContext(),ListSTD_Activity.class);

                int id = Integer.parseInt(listSTDModel.getId_std());

                intent.putExtra("id_std",id);
                intent.putExtra("status",Dropped);

                Log.i("ID ",""+id);
                Log.i("DROPPED ",""+Dropped);

                ServerConnecter connector = new ServerConnecter();
                connector.connect("update_listSTD_evening.php", true, false, new EntityModelListSTD(id,Dropped));

                startActivity(intent);

            }
        });

        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Absent = 3;
                Intent intent = new Intent(getApplicationContext(),ListSTD_Activity.class);

                int id = Integer.parseInt(listSTDModel.getId_std());

                intent.putExtra("id_std",id);
                intent.putExtra("status",Absent);

                Log.i("ID ",""+id);
                Log.i("ABSENT ",""+Absent);

                ServerConnecter connector = new ServerConnecter();
                connector.connect("update_listSTD_evening.php", true, false, new EntityModelListSTD(id,Absent));

                startActivity(intent);

            }
        });

        button_number_otp_EN = (Button)findViewById(R.id.btn_Number_OTP);
        button_number_otp_EN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_otp = new Intent(getApplicationContext(),Input_Number_OTP.class);

                startActivity(intent_otp);

            }
        });

        int id_parent_p = 0;

        ServerConnecter connecter = new ServerConnecter();
        String re =  connecter.connect16("select_idParent_numberPhone.php",true,true,new Model_IdParent_Number(id_p));
        JSONArray arr = connecter.getResponseArray(re);
        Log.i("Login JSON", ""+arr);

        for(int i=0;i<arr.length();i++) {

            try {
                data_count_number = new Data_Count_Number(arr.getJSONObject(i));
                id_parent_p = data_count_number.getNum();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        Log.i(" ID_PARENT : "," " +id_p);

        if (id_parent_p > 0 ){
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
        }else {
            button_number_otp_EN.setVisibility(View.GONE);
        }

        button_history_en = (Button)findViewById(R.id.btn_history_statusSTD);
        button_history_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_history = new Intent(getApplicationContext(), History_Person.class);

                int id = Integer.parseInt(listSTDModel.getId_std());
                intent_history.putExtra("id_stddd",id);
                Log.i("ID ",""+id);

                startActivity(intent_history);

            }
        });
    }
}
