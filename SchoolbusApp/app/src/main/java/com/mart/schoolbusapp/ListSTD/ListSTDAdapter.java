package com.mart.schoolbusapp.ListSTD;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.mart.schoolbusapp.R;
import java.util.ArrayList;

/**
 * Created by Mart_ on 8/11/2559.
 */

public class ListSTDAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ListSTDViewHolder.OnSelectedList {

    private ArrayList<ListSTDModel> arrayList;
    private sendDataToShow mCallback;

    public ListSTDAdapter(ArrayList<ListSTDModel> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void onclickCall(int position) {
        ListSTDModel s = arrayList.get(position);
        if (mCallback != null) {
            mCallback.sendData(s);
        }
    }

    public interface sendDataToShow {
        public void sendData(ListSTDModel listSTDModel);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_recycle, parent, false);
        ListSTDViewHolder listSTDViewHolder = new ListSTDViewHolder(view);
        listSTDViewHolder.setCallback(this);
        return listSTDViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

//        holder.bindData(arrayList.get(position));
//
//        //in some cases, it will prevent unwanted situations
//        holder.checkbox.setOnCheckedChangeListener(null);
//
//        //if true, your checkbox will be selected, else unselected
//        holder.checkbox.setChecked(arrayList.get(position).isSelected());
//
//        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                arrayList.get(holder.getAdapterPosition()).setSelected(isChecked);
//            }
//        });

        ListSTDModel s = arrayList.get(position);

        if (holder instanceof ListSTDViewHolder) {
            ListSTDViewHolder listSTDViewHolder = (ListSTDViewHolder) holder;
            listSTDViewHolder.setViewHolder(s);
            listSTDViewHolder.setCallback(this);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        private TextView ONEs;
//        private TextView textONEs;
//        private CheckBox checkbox;
//
//        public ViewHolder(View v) {
//            super(v);
//            ONEs = (TextView) v.findViewById(R.id.ONEs);
//            textONEs = (TextView) v.findViewById(R.id.textONEs);
//            checkbox = (CheckBox) v.findViewById(R.id.checkbox);
//        }
//
//        public void bindData(Number number) {
//            ONEs.setText(number.getONEs());
//            textONEs.setText(number.getTextONEs());
//        }
//    }

    public void setCallback(sendDataToShow mCallback) {
        this.mCallback = mCallback;
    }

}
