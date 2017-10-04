package com.mart.schoolbusapp.History_H_Student_Parent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.History_H.ListHistoryViewHolder;
import com.mart.schoolbusapp.History_H.ListHistory_Model;
import com.mart.schoolbusapp.R;

import java.util.ArrayList;

/**
 * Created by Mart_ on 7/3/2560.
 */

public class ListHistoryStudentOfParent_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListHistoryStudentOfParentViewHolder.OnHeadlineSelectedListener {

    private ArrayList<ListHistory_Model> arrayList;
    //private sendDataToShow mCallback;

    public ListHistoryStudentOfParent_Adapter(ArrayList<ListHistory_Model> listHistory_models){
        this.arrayList = listHistory_models;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup history_student, int viewType) {

        View view = LayoutInflater.from(history_student.getContext()).inflate(R.layout.data_history_student_parent,history_student, false);
        ListHistoryStudentOfParentViewHolder listHistoryStudentOfParentViewHolder = new ListHistoryStudentOfParentViewHolder(view);
        listHistoryStudentOfParentViewHolder.setCallback(this);
        return listHistoryStudentOfParentViewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListHistory_Model s = arrayList.get(position);

        if (holder instanceof ListHistoryStudentOfParentViewHolder){

            ListHistoryStudentOfParentViewHolder listHistoryStudentOfParentViewHolder = (ListHistoryStudentOfParentViewHolder) holder;
            listHistoryStudentOfParentViewHolder.setViewHolder(s);
            listHistoryStudentOfParentViewHolder.setCallback(this);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onclickCall(int position) {

    }
}
