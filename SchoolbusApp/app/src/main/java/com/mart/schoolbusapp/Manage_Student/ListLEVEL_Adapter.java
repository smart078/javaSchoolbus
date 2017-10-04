package com.mart.schoolbusapp.Manage_Student;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.R;

import java.util.ArrayList;

/**
 * Created by Mart_ on 8/2/2560.
 */

public class ListLEVEL_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListLEVELViewHolder.OnHeadlineSelectedListener {

    private ArrayList<ListLEVEL_Model> arrayList;
    //private sendDataToShow mCallback;

    public ListLEVEL_Adapter(ArrayList<ListLEVEL_Model> listLEVEL_models){
        this.arrayList = listLEVEL_models;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup level, int viewType) {

        View view = LayoutInflater.from(level.getContext()).inflate(R.layout.data_level_drievr, level, false);
        ListLEVELViewHolder listLEVELViewHolder = new ListLEVELViewHolder(view);
        listLEVELViewHolder.setCallback(this);
        return listLEVELViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListLEVEL_Model s = arrayList.get(position);

        if (holder instanceof ListLEVELViewHolder){

            ListLEVELViewHolder listLEVELViewHolder = (ListLEVELViewHolder) holder;
            listLEVELViewHolder.setViewHolder(s);
            listLEVELViewHolder.setCallback(this);
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
