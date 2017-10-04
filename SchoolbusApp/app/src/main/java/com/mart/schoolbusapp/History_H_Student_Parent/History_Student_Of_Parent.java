package com.mart.schoolbusapp.History_H_Student_Parent;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.mart.schoolbusapp.History_H.ListHistory_Model;
import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 7/3/2560.
 */

public class History_Student_Of_Parent extends FragmentActivity implements ListHistoryStudentOfParent_Fragment.OnFragmentListener{

    int id_parent;
    private ListHistory_Model listHistory_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_student_of_parent);

        ListHistoryStudentOfParent_Fragment listHistoryStudentOfParent_fragment = new ListHistoryStudentOfParent_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_history_parent, listHistoryStudentOfParent_fragment, ListHistoryStudentOfParent_Fragment.class.getSimpleName());
        fragmentTransaction.commit();


    }

    public int getID_PARENT(){
        id_parent = getIntent().getIntExtra("id_parent",1);
        return id_parent;
    }

    @Override
    public void onFragmentInteractionPLACE(Uri uri) {

    }
}
