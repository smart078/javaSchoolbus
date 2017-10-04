package com.mart.schoolbusapp.Place_Place;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.R;

import java.util.ArrayList;

/**
 * Created by Mart_ on 2/1/2560.
 */

public class ListPLACEAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListPLACEViewHolder.OnHeadlineSelectedListener {

    private ArrayList<ListPLACEModel> arrayList;
    private sendDataToShow mCallback;


    public ListPLACEAdapter(ArrayList<ListPLACEModel> listPLACEModels){
        this.arrayList = listPLACEModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_place, parent, false);
        ListPLACEViewHolder listPLACEViewHolder = new ListPLACEViewHolder(view);
        listPLACEViewHolder.setCallback(this);
        return listPLACEViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListPLACEModel s = arrayList.get(position);

        if (holder instanceof ListPLACEViewHolder){

            ListPLACEViewHolder listPLACEViewHolder = (ListPLACEViewHolder) holder;
            listPLACEViewHolder.setViewHolder(s);
            listPLACEViewHolder.setCallback(this);
        }

    }

    @Override
    public void onclickCall(int position) {
        ListPLACEModel s = arrayList.get(position);
        if (mCallback != null) {
            mCallback.sendData(s);
        }
    }

    public interface sendDataToShow {
        public void sendData(ListPLACEModel model);
    }

    public void setCallback(sendDataToShow mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
