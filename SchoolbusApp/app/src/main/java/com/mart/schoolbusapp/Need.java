package com.mart.schoolbusapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mart.schoolbusapp.Place_Place.ListPLACEModel;
import com.mart.schoolbusapp.Place_Place.ListPLACEModel_Need_MN;
import com.mart.schoolbusapp.Place_Place.ListPLACEViewHolder;
import com.mart.schoolbusapp.Place_Place.Model_Need_MN;
import com.mart.schoolbusapp.Place_Place.Model_Parent_Need_MN;
import com.mart.schoolbusapp.Place_Place.Place;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 3/11/2559.
 */

public class Need extends Activity {

    private ListPLACEModel_Need_MN listPLACEModel_need_mn;

    private String descroption;
    private String name_parent;
    private int id_address;
    private int id_parent = 2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.need);

        final ServerConnecter connecter = new ServerConnecter();
        String re = connecter.connect19("Select_detail_ParentAddress_MN.php",true,true,new Model_Parent_Need_MN(id_parent));

        JSONArray arr = connecter.getResponseArray(re);
        Log.i("ARR",""+arr);


        for(int i=0;i<arr.length();i++) {

            try {
                listPLACEModel_need_mn = new ListPLACEModel_Need_MN(arr.getJSONObject(i));

                Log.i("Model",""+listPLACEModel_need_mn);

                descroption = listPLACEModel_need_mn.getDescription();
                name_parent = listPLACEModel_need_mn.getName_parent();
                id_address = listPLACEModel_need_mn.getId_address();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        AlertDialog.Builder builder =
                new AlertDialog.Builder(Need.this);
        builder.setMessage("กรุณาระบุความต้องการขึ้นรถโรงเรียน " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                "สถานที่ : " + descroption + " " + " " + " "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " + "่ผู้ปกครองที่รับ : " + name_parent + " " + " " + " " + " " + " " + " " + " " + " " + " " + " "+" ถ้าขึ้นรถและข้อมูลถูกต้อง : กรุณากดปุ่ม ขึ้นรถ" +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                "หรือ ถ้าไม่ขึ้นรถ : กรุณากดปุ่ม ไม่ขึ้นรถ" + " "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+" " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+ " " +" "+
                "หรือ ถ้ามีการเปลี่ยนแปลงข้อมูล : กรุณากดปุ่ม เปลี่ยนแปลง");
        builder.setPositiveButton("ขึ้นรถ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                int id_statusNeed = 1;
                int id_number_phone = 0;

                ServerConnecter connector = new ServerConnecter();
                connecter.connect18("insert_need_list_numberphone.php",true,false,new Model_Need_MN(id_parent,id_address,id_statusNeed,id_number_phone));

//                Intent intent = new Intent(getApplication(),Place.class);
//
//                intent.putExtra("id_statusNeed",id_statusNeed);
//
//                startActivity(intent);

                Toast.makeText(getApplicationContext(),
                        "SUCCESS", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("ไม่ขึ้นรถ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int id_statusNeed = 2;
                int id_address = 0;
                int id_number_phone = 0;

                Intent intent = new Intent(getApplication(),Main_Login.class);
                startActivity(intent);

                ServerConnecter connector = new ServerConnecter();
                connector.connect11("insert_need_list_numberphone.php", true, false, new Model_StatusNeed(id_statusNeed,id_parent,id_address,id_number_phone));

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("เปลี่ยนแปลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int id_statusNeed = 1;

                Intent intent = new Intent(getApplication(),Place.class);

                intent.putExtra("id_statusNeed",id_statusNeed);
                intent.putExtra("id_parent",id_parent);

                startActivity(intent);
            }
        });

        builder.show();

    }
}
