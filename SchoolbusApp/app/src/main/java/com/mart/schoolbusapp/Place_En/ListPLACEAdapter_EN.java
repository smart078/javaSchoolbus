package com.mart.schoolbusapp.Place_En;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.Place_Place.ListPLACEModel;
import com.mart.schoolbusapp.R;

import java.util.ArrayList;

/**
 * Created by Mart_ on 16/1/2560.
 */

public class ListPLACEAdapter_EN extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListPLACEViewHolder_EN.OnHeadlineSelectedListener {

    private ArrayList<ListPLACEModel> arrayList;
    private sendDataToShow mCallback;

    public ListPLACEAdapter_EN(ArrayList<ListPLACEModel> listPLACEModels){
        this.arrayList = listPLACEModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_place_en, parent, false);
        ListPLACEViewHolder_EN listPLACEViewHolder_en = new ListPLACEViewHolder_EN(view);
        listPLACEViewHolder_en.setCallback(this);
        return listPLACEViewHolder_en;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ListPLACEModel s = arrayList.get(position);

        if (holder instanceof ListPLACEViewHolder_EN){

            ListPLACEViewHolder_EN listPLACEViewHolder_en = (ListPLACEViewHolder_EN) holder;
            listPLACEViewHolder_en.setViewHolder(s);
            listPLACEViewHolder_en.setCallback(this);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
}
