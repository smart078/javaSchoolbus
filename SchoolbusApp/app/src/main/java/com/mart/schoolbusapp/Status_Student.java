package com.mart.schoolbusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mart.schoolbusapp.History_H_Person.History_Person;
import com.mart.schoolbusapp.ListSTD.EntityModelListSTD;
import com.mart.schoolbusapp.ListSTD.ListSTDModel;
import com.mart.schoolbusapp.Login.Login_Teacher;
import com.mart.schoolbusapp.Server.ServerConnecter;

/**
 * Created by Mart_ on 7/11/2559.
 */

public class Status_Student extends Activity {

    private TextView id_std;
    private TextView std_name;
    private TextView std_edu;
    private TextView parent_name;
    private TextView parent_tel;
    private ListSTDModel listSTDModel;

    private Button button_history;
    private Button button_number_otp_MN;
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
                connector.connect("update_listSTD_morning.php", true, false, new EntityModelListSTD(id,In_bus));

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
                connector.connect("update_listSTD_morning.php", true, false, new EntityModelListSTD(id,Dropped));

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
                connector.connect("update_listSTD_morning.php", true, false, new EntityModelListSTD(id,Absent));

                startActivity(intent);

            }
        });

        button_number_otp_MN = (Button)findViewById(R.id.btn_Number_OTP);
        button_number_otp_MN.setVisibility(View.GONE);

        button_history = (Button)findViewById(R.id.btn_history_statusSTD);
        button_history.setOnClickListener(new View.OnClickListener() {
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
