package com.mart.schoolbusapp.Place_Place;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mart.schoolbusapp.Model_StatusNeed;
import com.mart.schoolbusapp.NumberPhone_Parent.Input_Number_Parent;
import com.mart.schoolbusapp.Place_Place.ListPLACEModel;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

public class ListPLACEViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView name_place;
    private TextView name_place2;
    private TextView name_place3;
    private TextView name_place4;
    private TextView name_place5;
    private TextView name_place6;
    private TextView name_place7;
    private TextView name_place8;

    private Context context;

    private ListPLACEModel placeModel;

    private Button btn_choose;

    private int id_parent;

    OnHeadlineSelectedListener mCallback;

//    public ListPLACEViewHolder(View itemView, Context context) {
//        super(itemView);
//        this.context = context;
//    }

    public interface OnHeadlineSelectedListener {
        public void onclickCall(int position);
    }


    public ListPLACEViewHolder(View itemView) {

        super(itemView);
        name_place = (TextView)itemView.findViewById(R.id.tv_place);
//        name_place2 = (TextView)itemView.findViewById(R.id.tv_place2);
        name_place3 = (TextView)itemView.findViewById(R.id.tv_place3);
        name_place3.setVisibility(View.GONE);

        name_place4 = (TextView)itemView.findViewById(R.id.tv_place4);
        name_place4.setVisibility(View.GONE);
//        name_place5 = (TextView)itemView.findViewById(R.id.tv_place5);
//        name_place6 = (TextView)itemView.findViewById(R.id.tv_place6);
//        name_place6.setVisibility(View.GONE);
//
//        name_place7 = (TextView)itemView.findViewById(R.id.tv_place7);
//        name_place7.setVisibility(View.GONE);
//
//        name_place8 = (TextView)itemView.findViewById(R.id.tv_place8);
//        name_place8.setVisibility(View.GONE);

        btn_choose =(Button)itemView.findViewById(R.id.btn_choose);
        btn_choose.setOnClickListener(this);

    }

    public void setViewHolder(ListPLACEModel placeModel){

        name_place.setText(placeModel.getDescription());
//        name_place2.setText(placeModel.getNumber_village());
        name_place3.setText(placeModel.getId_parent()+"");
        name_place4.setText(placeModel.getId_address()+"");
//        name_place5.setText(placeModel.getSubdistrict());
//        name_place6.setText(placeModel.getDistrict());
//        name_place7.setText(placeModel.getProvince());
//        name_place8.setText(placeModel.getNumber_post());
    }

    public void setCallback(OnHeadlineSelectedListener mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onClick(final View v) {

        if (mCallback != null) {
            mCallback.onclickCall(getAdapterPosition());
            int position = getAdapterPosition();
            Log.i("Cilck MN ",""+getAdapterPosition());

            ServerConnecter connecter = new ServerConnecter();

            id_parent = Integer.parseInt((String) name_place3.getText());
            int id_address = Integer.parseInt((String) name_place4.getText());
            int id_number_phone = 0;

            Log.i("data MN "," ID PARENT MN " + id_parent + " ID ADDRESS MN " + id_address);
            //Log.i("address ",""+name_place.getText());

            connecter.connect11("insert_need_list_numberphone.php",true,false,new Model_StatusNeed(1,id_parent,id_address,id_number_phone));

            Intent intent = new Intent(v.getContext(),Success.class);
            Toast.makeText(v.getContext(),"Success Choose",Toast.LENGTH_LONG).show();
            v.getContext().startActivity(intent);

        }

    }

    public int getID_Parent_MN(){
        int id_parent_MN = placeModel.getId_parent();

        return id_parent_MN;
    }

    public int getID_Address_MN(){
        int id_address_MN = placeModel.getId_address();

        return id_address_MN;
    }
}
