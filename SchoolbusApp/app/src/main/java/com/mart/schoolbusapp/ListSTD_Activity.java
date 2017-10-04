package com.mart.schoolbusapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mart.schoolbusapp.Server.ServerConnecter;
import com.mart.schoolbusapp.Teacher.Add_STD;
import com.mart.schoolbusapp.Teacher.Data_Teacher;
import com.mart.schoolbusapp.Teacher.MyPageAdapter;
import com.mart.schoolbusapp.Teacher.Update_Teacher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ListSTD_Activity extends FragmentActivity implements ListMN_Fragment.OnFragmentInteractionListener ,ListEN_Fragment.OnFragmentListener {

    private Button btn_morning_list;
    private Button btn_evening_list;

    private Button btn_getSelect_All;

    private ViewPager pager;
//
//    private Button btn_update_teacher;
//    private Button btn_add_teacher;

    private static final DateFormat sdf = new SimpleDateFormat("H");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liststd);

        Date date = new Date();
        String hour = sdf.format(date);
        //int hh = Integer.parseInt(hour);
        int hh = 8;
        Log.i("hh is ",""+hh);


//        btn_update_teacher = (Button)findViewById(R.id.button_listSTD_update_teacher);
//        btn_update_teacher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
//
//        btn_add_teacher = (Button)findViewById(R.id.button_listSTD_add_teacher);
//        btn_add_teacher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });


        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);

        btn_morning_list = (Button)findViewById(R.id.btn_list_morning);
        btn_morning_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem()-1);
//                ListMN_Fragment listMN_fragment = new ListMN_Fragment();
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.activity_liststd, listMN_fragment, ListMN_Fragment.class.getSimpleName());
//                fragmentTransaction.commit();
            }
        });

        btn_evening_list = (Button)findViewById(R.id.btn_list_evening);
        btn_evening_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(pager.getCurrentItem()+1);
//                ListEN_Fragment listEN_fragment = new ListEN_Fragment();
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.activity_liststd,listEN_fragment,ListEN_Fragment.class.getSimpleName());
//                fragmentTransaction.commit();

            }
        });

        btn_getSelect_All = (Button)findViewById(R.id.btnGetSelected_All);
        btn_getSelect_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(" ต้องการเลือกลงจากรถทั้งหมด ?" );
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ServerConnecter connecter = new ServerConnecter();
                        connecter.connect("update_status_student_all.php",false,false,null);

                        Toast.makeText(getApplication(),"Success Update",Toast.LENGTH_LONG).show();

                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                builder.show();

            }


        });

        if (hh >= 8 && hh <= 10){
            Log.i("mornning ",""+hh);

        }else {
            Log.i("undifine ",""+hh);
            btn_getSelect_All.setVisibility(View.GONE);
        }

    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteractionEN(Uri uri) {

    }


}