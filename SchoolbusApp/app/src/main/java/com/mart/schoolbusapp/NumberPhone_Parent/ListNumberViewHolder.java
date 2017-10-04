package com.mart.schoolbusapp.NumberPhone_Parent;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 17/1/2560.
 */

public class ListNumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tv_numparent1;
    private TextView tv_numparent2;

    private ListNumberModel listNumberModel;

    private Button btn_choose_numberr;

    OnHeadlineSelectedListener mCallback;


    public interface OnHeadlineSelectedListener {
        public void onclickCall(int position);
    }

    public ListNumberViewHolder(View itemView) {

        super(itemView);

        tv_numparent1 = (TextView) itemView.findViewById(R.id.tv_num_parent);
        tv_numparent2 = (TextView) itemView.findViewById(R.id.tv_num_parent_2);

        btn_choose_numberr = (Button) itemView.findViewById(R.id.btn_choose_num_phone);
        btn_choose_numberr.setOnClickListener(this);

    }

    public void setViewHolder(ListNumberModel numberModel) {

        tv_numparent1.setText(numberModel.getPhone_number());
        tv_numparent2.setText(numberModel.getPhone_name());

    }

    public void setCallback(OnHeadlineSelectedListener mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onClick(View v) {

        if(mCallback!=null){
            mCallback.onclickCall(getAdapterPosition());
            int position = getAdapterPosition();
            Log.i("Cilck  ", "" + getAdapterPosition());

        }

    }



}

