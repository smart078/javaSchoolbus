package com.mart.schoolbusapp.NumberPhone_Parent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mart_ on 17/1/2560.
 */

public class ListNumberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListNumberViewHolder.OnHeadlineSelectedListener {

    private ArrayList<ListNumberModel> arrayList;
    private sendDataToShow mCallback;


    public ListNumberAdapter(ArrayList<ListNumberModel> listNumberModels){
        this.arrayList = listNumberModels;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_numparent, parent, false);
        ListNumberViewHolder listNumberViewHolder = new ListNumberViewHolder(view);
        listNumberViewHolder.setCallback(this);
        return listNumberViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListNumberModel s = arrayList.get(position);

        if (holder instanceof ListNumberViewHolder){

            ListNumberViewHolder listNumberViewHolder = (ListNumberViewHolder) holder;
            listNumberViewHolder.setViewHolder(s);
            listNumberViewHolder.setCallback(this);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onclickCall(int position) {

        ListNumberModel s = arrayList.get(position);
        if (mCallback != null) {
            mCallback.sendData(s);
        }

    }

    public interface sendDataToShow {
        public void sendData(ListNumberModel model);
    }

    public void setCallback(sendDataToShow mCallback) {
        this.mCallback = mCallback;
    }


}
