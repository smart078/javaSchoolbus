package com.mart.schoolbusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mart.schoolbusapp.Login.Login_Driver;
import com.mart.schoolbusapp.Login.Login_Parent;
import com.mart.schoolbusapp.Login.Login_Teacher;

/**
 * Created by Mart_ on 24/11/2559.
 */

public class Main_PTD extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ptd);

        Button btn_driver = (Button)findViewById(R.id.BTN_Driver);
        btn_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(),Login_Driver.class);
                startActivity(intent1);

            }
        });

        Button btn_teacher = (Button)findViewById(R.id.BTN_Teacher);
        btn_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(getApplicationContext(),Login_Teacher.class);
                startActivity(intent2);


            }
        });

        Button btn_parent = (Button)findViewById(R.id.BTN_Parent);
        btn_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(getApplicationContext(),Login_Parent.class);
                startActivity(intent3);

            }
        });
    }

}
