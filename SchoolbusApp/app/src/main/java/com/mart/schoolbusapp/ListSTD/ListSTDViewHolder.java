package com.mart.schoolbusapp.ListSTD;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mart.schoolbusapp.ListSTD.ListSTDModel;
import com.mart.schoolbusapp.R;


/**
 * Created by Mart_ on 8/11/2559.
 */

public class ListSTDViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//    private TextView id_std;
    private TextView std_name;
    private TextView std_edu;
    private TextView parent_name;
    private TextView parent_tel;
    private ImageView std_pic;
    private TextView status_stu;

    OnSelectedList mCallback;

    public interface OnSelectedList {
        public void onclickCall(int position);
    }

    public ListSTDViewHolder(View itemView) {
        super(itemView);
//        id_std = (TextView)itemView.findViewById(R.id.TVCODE);
        std_name = (TextView)itemView.findViewById(R.id.TVName);
        std_edu = (TextView)itemView.findViewById(R.id.TVEdu);
        parent_name = (TextView)itemView.findViewById(R.id.TVParent);
        parent_tel = (TextView)itemView.findViewById(R.id.TVTel);
        std_pic = (ImageView) itemView.findViewById(R.id.iv_01);
        status_stu = (TextView)itemView.findViewById(R.id.TVSTS);

        std_pic.setOnClickListener(this);
    }

    public void setViewHolder(ListSTDModel stdmodel) {

//        id_std.setText(stdmodel.getId_std());
        std_name.setText(stdmodel.getStd_name());
        std_edu.setText(stdmodel.getStd_edu());
        parent_name.setText(stdmodel.getParent_name());
        parent_tel.setText(stdmodel.getParent_tel());
        status_stu.setText(stdmodel.getStatus());
    }

    public void setCallback(OnSelectedList mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onClick(View v) {
        if (mCallback != null) {
            mCallback.onclickCall(getAdapterPosition());
        }
    }
}
