package com.mart.schoolbusapp.History_H_Person;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.History_H.ListHistoryViewHolder;
import com.mart.schoolbusapp.History_H.ListHistory_Model;
import com.mart.schoolbusapp.R;

import java.util.ArrayList;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class ListHistoryPerson_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListHistoryPersonViewHolder.OnHeadlineSelectedListener {

    private ArrayList<ListHistory_Model> arrayList;
    //private sendDataToShow mCallback;

    public ListHistoryPerson_Adapter(ArrayList<ListHistory_Model> listHistory_models){
        this.arrayList = listHistory_models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup history_person, int viewType) {

        View view = LayoutInflater.from(history_person.getContext()).inflate(R.layout.data_history, history_person, false);
        ListHistoryPersonViewHolder listHistoryPersonViewHolder = new ListHistoryPersonViewHolder(view);
        listHistoryPersonViewHolder.setCallback(this);
        return listHistoryPersonViewHolder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListHistory_Model s = arrayList.get(position);

        if (holder instanceof ListHistoryPersonViewHolder){

            ListHistoryPersonViewHolder listHistoryPersonViewHolder = (ListHistoryPersonViewHolder) holder;
            listHistoryPersonViewHolder.setViewHolder(s);
            listHistoryPersonViewHolder.setCallback(this);
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
