package com.mart.schoolbusapp.History_H;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.R;

import java.util.ArrayList;

import static android.R.attr.level;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class ListHistory_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListHistoryViewHolder.OnHeadlineSelectedListener {

    private ArrayList<ListHistory_Model> arrayList;
    //private sendDataToShow mCallback;

    public ListHistory_Adapter(ArrayList<ListHistory_Model> listHistory_models){
        this.arrayList = listHistory_models;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup history, int viewType) {

        View view = LayoutInflater.from(history.getContext()).inflate(R.layout.data_history, history, false);
        ListHistoryViewHolder listHistoryViewHolder = new ListHistoryViewHolder(view);
        listHistoryViewHolder.setCallback(this);
        return listHistoryViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListHistory_Model s = arrayList.get(position);

        if (holder instanceof ListHistoryViewHolder){

            ListHistoryViewHolder listHistoryViewHolder = (ListHistoryViewHolder) holder;
            listHistoryViewHolder.setViewHolder(s);
            listHistoryViewHolder.setCallback(this);
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
