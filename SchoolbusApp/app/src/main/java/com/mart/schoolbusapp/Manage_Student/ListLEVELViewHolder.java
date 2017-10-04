package com.mart.schoolbusapp.Manage_Student;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 8/2/2560.
 */

public class ListLEVELViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_detaill;
    private TextView tv_detaill_1;
    private TextView tv_detaill_2;
    private TextView tv_detaill_3;

    private ListLEVEL_Model listLEVEL_model;

    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {
        public void onclickCall(int position);
    }

    public ListLEVELViewHolder(View itemView) {
        super(itemView);

        tv_detaill = (TextView)itemView.findViewById(R.id.tv_detial);
        tv_detaill_1 = (TextView)itemView.findViewById(R.id.tv_detail_1);

        tv_detaill_2 = (TextView)itemView.findViewById(R.id.tv_detail_2);
        tv_detaill_2.setVisibility(View.GONE);

        tv_detaill_3 = (TextView)itemView.findViewById(R.id.tv_detail_3);
        tv_detaill_3.setVisibility(View.GONE);
    }

    public void setViewHolder(ListLEVEL_Model level_model) {

        tv_detaill.setText(level_model.getName_student());
        tv_detaill_1.setText(level_model.getAddress_student());

        tv_detaill_2.setText(level_model.getLatitude());
        tv_detaill_3.setText(level_model.getLongitude());

    }

    public void setCallback(OnHeadlineSelectedListener mCallback) {
        this.mCallback = mCallback;
    }
}
