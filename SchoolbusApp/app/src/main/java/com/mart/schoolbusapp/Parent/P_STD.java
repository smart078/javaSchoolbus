package com.mart.schoolbusapp.Parent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mart.schoolbusapp.History_H_Student_Parent.History_Student_Of_Parent;
import com.mart.schoolbusapp.Parent.Model_Parent.Model_Infor_P;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 9/12/2559.
 */

public class P_STD extends Fragment {

    private TextView tv_morning_id;
    private TextView tv_morning_name;
    private TextView tv_morning_level;
    private TextView tv_morning_status;

    private TextView tv_evening_id;
    private TextView tv_evening_name;
    private TextView tv_evening_level;
    private TextView tv_evening_status;

    private Button btn_history_parent;

    private Data_STD_P std_p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.p_std, container, false);

        tv_morning_id = (TextView)view.findViewById(R.id.TVSTD_Morning_id);
        tv_morning_name = (TextView)view.findViewById(R.id.TVSTD_Morning_name);
        tv_morning_level = (TextView)view.findViewById(R.id.TVSTD_Morning_edu);
        tv_morning_status = (TextView)view.findViewById(R.id.TVSTD_Morning_status);

        tv_evening_id = (TextView)view.findViewById(R.id.TVSTD_Evening_id);
        tv_evening_name = (TextView)view.findViewById(R.id.TVSTD_Evening_name);
        tv_evening_level = (TextView)view.findViewById(R.id.TVSTD_Evening_edu);
        tv_evening_status = (TextView)view.findViewById(R.id.TVSTD_Evening_status);

        Part_Parent p = (Part_Parent) getActivity();
        final int id = p.getID_P();
        Log.i("ID P_std",""+id);

        btn_history_parent = (Button)view.findViewById(R.id.BTN_HISTORY_PARENT);
        btn_history_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), History_Student_Of_Parent.class);

                intent.putExtra("id_parent",id);

                startActivity(intent);

            }
        });

        ServerConnecter connecter = new ServerConnecter();

        String re = connecter.connect9("get_std_p_mn.php",true,true,new Model_Infor_P(id));
        JSONArray arr = connecter.getResponseArray(re);

        for(int i=0;i<arr.length();i++) {

            try {
                std_p = new Data_STD_P(arr.getJSONObject(i));
                tv_morning_id.setText(String.valueOf(std_p.getId_student()));
                tv_morning_name.setText(std_p.getName_student());
                tv_morning_level.setText(std_p.getEducation_student());
                tv_morning_status.setText(std_p.getStatus_std());
                Log.i("status mn",""+std_p.getStatus_std());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        String ree = connecter.connect9("get_std_p_en.php",true,true,new Model_Infor_P(id));
        JSONArray ar = connecter.getResponseArray(ree);

        for(int i=0;i<ar.length();i++) {

            try {
                std_p = new Data_STD_P(ar.getJSONObject(i));
                tv_evening_id.setText(String.valueOf(std_p.getId_student()));
                tv_evening_name.setText(std_p.getName_student());
                tv_evening_level.setText(std_p.getEducation_student());
                tv_evening_status.setText(std_p.getStatus_std());
                Log.i("status en",""+std_p.getStatus_std());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return view;
    }
}
