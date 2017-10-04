package com.mart.schoolbusapp.Parent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mart.schoolbusapp.Parent.Model_Parent.Model_Infor_P;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 9/12/2559.
 */

public class P_DataDriver extends Fragment {

    private TextView tv_id_driver;
    private TextView tv_name_driver;
    private TextView tv_tel_driver;
    private TextView tv_car_driver;

    private TextView tv_teacher_id;
    private TextView tv_teacher_name;
    private TextView tv_teacher_tel;

    private Data_Info_P data_info_p;
    private Data_parent parent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.p_datadriver, container, false);

        tv_id_driver = (TextView)view.findViewById(R.id.tv_info_driver_id);
        tv_name_driver = (TextView)view.findViewById(R.id.tv_info_driver_name);
        tv_tel_driver = (TextView)view.findViewById(R.id.tv_info_driver_tel);
        tv_car_driver = (TextView)view.findViewById(R.id.tv_info_driver_car);

        tv_teacher_id = (TextView)view.findViewById(R.id.tv_info_teacher_id);
        tv_teacher_name = (TextView)view.findViewById(R.id.tv_info_teacher_name);
        tv_teacher_tel = (TextView)view.findViewById(R.id.tv_info_teacher_tel);


        Part_Parent p = (Part_Parent) getActivity();
        int id = p.getID_P();
        Log.i("ID P_data Driver",""+id);

        ServerConnecter connecter = new ServerConnecter();
        String re = connecter.connect9("select_Information_P.php",true,true,new Model_Infor_P(id));

        JSONArray arr = connecter.getResponseArray(re);
        Log.i("ARR : ",""+ arr);
        Log.i("ARR COUNT : ",""+ arr.length());

        for(int i=0;i<arr.length();i++) {

            try {
                data_info_p = new Data_Info_P(arr.getJSONObject(i));
                tv_id_driver.setText(String.valueOf(data_info_p.getId_driver()));
                tv_name_driver.setText(data_info_p.getName_driver());
                tv_tel_driver.setText(data_info_p.getTel_driver());
                tv_car_driver.setText(data_info_p.getCar_registration());

                tv_teacher_id.setText(String.valueOf(data_info_p.getId_teacher()));
                tv_teacher_name.setText(data_info_p.getName_teacher());
                tv_teacher_tel.setText(data_info_p.getTel_teacher());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return view;
    }

}
