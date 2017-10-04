package com.mart.schoolbusapp.Parent;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mart.schoolbusapp.History_H_Student_Parent.History_Student_Of_Parent;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Tracking.Mylocation;
import com.mart.schoolbusapp.Tracking.getlocationlisterner;

/**
 * Created by Mart_ on 25/11/2559.
 */

public class Part_Parent extends FragmentActivity implements getlocationlisterner {

    private Button BTN_EDIT;
    private TextView id_parent;
    private TextView name_parent;

    private Data_parent parent;

    private int id;
    private String name;
    private String tel;
    private String email;
    private String password;

    private ViewPager pager;

    private Button btn_tracking;
    private Button btn_std;
    private Button btn_datadriver;

    private Button btn_history_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_parent);

        id_parent = (TextView)findViewById(R.id.tv1_part_parent);
        name_parent = (TextView)findViewById(R.id.tv2_part_parent);

        parent = getIntent().getExtras().getParcelable("PARENT");
        id_parent.setText(String.valueOf(parent.getId_parent()));
        name_parent.setText(parent.getName_parent());

        id = parent.getId_parent();
        name = parent.getName_parent();
        tel = parent.getTel_parent();
        email = parent.getEmail_parent();
        password = parent.getPassword_parent();


        BTN_EDIT = (Button)findViewById(R.id.BTN_EDIT_PARENT);
        BTN_EDIT.setVisibility(View.GONE);
        BTN_EDIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(),Update_Parent_P.class);
                final Data_parent p = new Data_parent(email,id,name,password,tel);
                intent.putExtra("P", p);

                startActivity(intent);

            }
        });


        MyPagerAdapter_Parent adapter_parent = new MyPagerAdapter_Parent(getSupportFragmentManager());
        pager = (ViewPager)findViewById(R.id.pagerr);
        pager.setAdapter(adapter_parent);
//        pager.setCurrentItem(2);

        btn_tracking = (Button)findViewById(R.id.P_btnTracking);
        btn_tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("cilck btn_tracking"," now : "+(pager.getCurrentItem()));
                int item = pager.getCurrentItem();
                Log.i("item : ",""+item);

                if (item==0) {

                    pager.setCurrentItem(item);
                    Log.i("page 1 cilck 1"," Item : "+item);

                }else if (item==1){

                    pager.setCurrentItem(item-1);
                    Log.i("page 2 cilck 1"," Item : "+(item-1));

                }else if (item==2){

                    pager.setCurrentItem(item-2);
                    Log.i("page 3 cilck 1"," Item : "+(item-2));

                }
            }
        });

        btn_std = (Button)findViewById(R.id.P_btnSTD);
        btn_std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("cilck btn_std"," now : "+(pager.getCurrentItem()));
                int item = pager.getCurrentItem();
                Log.i("item : ",""+item);

                if (item==0){

                    pager.setCurrentItem(item+1);
                    Log.i("page 1 cilck 2"," Item : "+(item+1));

                }else if (item==1){

                    pager.setCurrentItem(item);
                    Log.i("page 2 cilck 2"," Item : "+item);

                }else if (item==2){

                    pager.setCurrentItem(item-1);
                    Log.i("page 3 cilck 2"," Item : "+(item-1));

                }

            }
        });

        btn_datadriver = (Button)findViewById(R.id.P_btnDataDriver);
        btn_datadriver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("cilck btn_datadriver"," now : "+(pager.getCurrentItem()));
                int item = pager.getCurrentItem();
                Log.i("item : ",""+item);

                if (item==0){
                    pager.setCurrentItem(item+2);
                    Log.i("page 1 cilck 3"," Item : "+(item+2));

                }else if (item==1){

                    pager.setCurrentItem(item+1);
                    Log.i("page 2 cilck 3"," Item : "+(item+1));

                }else if (item==2){

                    pager.setCurrentItem(item);
                    Log.i("page 3 cilck 3"," Item : "+item);
                }
            }
        });

       /// Mylocation mylocation = new Mylocation(Part_Parent.this);
        //mylocation.Startlocation();

    }

    public int getID_P(){
        int id = parent.getId_parent();
        return id;
    }


    @Override
    public void getLatLongLocation(Location location) {

        Log.e("Location",""+location.getLatitude());

    }



}
