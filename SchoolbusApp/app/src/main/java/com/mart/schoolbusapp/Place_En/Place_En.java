package com.mart.schoolbusapp.Place_En;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.mart.schoolbusapp.NumberPhone_Parent.Number_Phone;
import com.mart.schoolbusapp.Place_Place.ListPLACE_Fragment;
import com.mart.schoolbusapp.Place_Place.Place;
import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 15/1/2560.
 */

public class Place_En extends FragmentActivity implements ListPLACE_Fragment_EN.OnFragmentListener {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place);

//        int id_statusNeed = getIntent().getIntExtra("id_statusNeed",1);
//        Log.i("id_statusNeed EN"," : "+id_statusNeed);



        ListPLACE_Fragment_EN place_fragment_en = new ListPLACE_Fragment_EN();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_place, place_fragment_en, ListPLACE_Fragment_EN.class.getSimpleName());
        fragmentTransaction.commit();
    }

    public int getID_PARENT_P_EN(){
        int id_parent = getIntent().getIntExtra("id_parent",1);
        return id_parent;
    }

    @Override
    public void onFragmentInteractionPLACE(Uri uri) {

    }
}
