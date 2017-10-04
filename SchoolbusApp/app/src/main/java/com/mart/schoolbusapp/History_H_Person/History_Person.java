package com.mart.schoolbusapp.History_H_Person;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.mart.schoolbusapp.History_H.ListHistory_Model;
import com.mart.schoolbusapp.R;

public class History_Person extends FragmentActivity implements ListHistoryPerson_Fragment.OnFragmentListener {

    int id_student;
    private ListHistory_Model listHistory_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_person);

        ListHistoryPerson_Fragment listHistoryPerson_fragment = new ListHistoryPerson_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_history_person, listHistoryPerson_fragment, ListHistoryPerson_Fragment.class.getSimpleName());
        fragmentTransaction.commit();

    }

    public int getID_STUDENT(){
        id_student = getIntent().getIntExtra("id_stddd",1);
        return id_student;
    }

    @Override
    public void onFragmentInteractionPLACE(Uri uri) {

    }
}
