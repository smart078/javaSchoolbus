package com.mart.schoolbusapp.History_H;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class History extends FragmentActivity implements ListHistory_Fragment.OnFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        ListHistory_Fragment listHistory_fragment = new ListHistory_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_history, listHistory_fragment, ListHistory_Fragment.class.getSimpleName());
        fragmentTransaction.commit();


    }

    @Override
    public void onFragmentInteractionPLACE(Uri uri) {

    }
}
