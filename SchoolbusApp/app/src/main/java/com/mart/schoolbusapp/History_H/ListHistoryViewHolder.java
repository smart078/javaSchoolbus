package com.mart.schoolbusapp.History_H;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class ListHistoryViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_nameStudent;
    private TextView tv_dateTime;
    private TextView tv_peroid;
    private TextView tv_status;

    private ListHistory_Model listHistory_model;

    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {
        public void onclickCall(int position);
    }

    public ListHistoryViewHolder(View itemView) {

        super(itemView);
        tv_nameStudent = (TextView)itemView.findViewById(R.id.tv_nameStudent_history);
        tv_dateTime = (TextView)itemView.findViewById(R.id.tv_dateTime_history);
        tv_peroid = (TextView)itemView.findViewById(R.id.tv_Period_history);
        tv_status = (TextView)itemView.findViewById(R.id.tv_status_history);

    }

    public void setViewHolder(ListHistory_Model listHistory_model) {

        tv_nameStudent.setText(listHistory_model.getName_student());
        tv_dateTime.setText(listHistory_model.getTime_date());
        tv_peroid.setText(listHistory_model.getPeriod());
        tv_status.setText(listHistory_model.getStatus_student());

    }

    public void setCallback(OnHeadlineSelectedListener mCallback){
        this.mCallback = mCallback;
    }


}
