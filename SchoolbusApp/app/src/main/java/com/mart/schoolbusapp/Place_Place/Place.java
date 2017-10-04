package com.mart.schoolbusapp.Place_Place;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 2/1/2560.
 */

public class Place extends FragmentActivity implements ListPLACE_Fragment.OnFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place);

        ListPLACE_Fragment place_fragment = new ListPLACE_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_place, place_fragment, ListPLACE_Fragment.class.getSimpleName());
        fragmentTransaction.commit();

    }

    public int getID_PARENT_P(){
        int id_parent = getIntent().getIntExtra("id_parent",2);
        return id_parent;
    }

    @Override
    public void onFragmentInteractionPLACE(Uri uri) {

    }
}
