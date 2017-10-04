package com.mart.schoolbusapp.Place_En;

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
import com.mart.schoolbusapp.Parent.Part_Parent;
import com.mart.schoolbusapp.Place_Place.ListPLACEModel;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

/**
 * Created by Mart_ on 16/1/2560.
 */

public class ListPLACEViewHolder_EN extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name_place;
//    private TextView name_place2;
    private TextView name_place3;
    private TextView name_place4;
    private TextView name_place5;
    private TextView name_place6;
    private TextView name_place7;
    private TextView name_place8;

    private ListPLACEModel placeModel;

    private Button btn_choose_en;

    private Context context;

    private int id_parent;
    private int id_address;
    private int id_statusNeed;

    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {
        public void onclickCall(int position);
    }

    public ListPLACEViewHolder_EN(View itemView) {

        super(itemView);
        name_place = (TextView)itemView.findViewById(R.id.tv_place_en1);
//        name_place2 = (TextView)itemView.findViewById(R.id.tv_place2);
        name_place3 = (TextView)itemView.findViewById(R.id.tv_place_en3);
        name_place3.setVisibility(View.GONE);

        name_place4 = (TextView)itemView.findViewById(R.id.tv_place_en4);
        name_place4.setVisibility(View.GONE);

        name_place5 = (TextView)itemView.findViewById(R.id.tv_place_en5);
        name_place5.setVisibility(View.GONE);
//
//        name_place6 = (TextView)itemView.findViewById(R.id.tv_place_en6);
//        name_place6.setVisibility(View.GONE);
//
//        name_place7 = (TextView)itemView.findViewById(R.id.tv_place_en7);
//        name_place7.setVisibility(View.GONE);
//
//        name_place8 = (TextView)itemView.findViewById(R.id.tv_place_en8);
//        name_place8.setVisibility(View.GONE);

        btn_choose_en =(Button)itemView.findViewById(R.id.btn_choose_en);
        btn_choose_en.setOnClickListener(this);

    }

    public void setViewHolder(ListPLACEModel placeModel){

        name_place.setText(placeModel.getDescription());
//        name_place2.setText(placeModel.getNumber_village());
        name_place3.setText(placeModel.getId_parent()+"");
        name_place4.setText(placeModel.getId_address()+"");
        name_place5.setText(placeModel.getName_parent());
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
            Log.i("Cilck ",""+getAdapterPosition());

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setMessage(name_place5.getText() + " คือคนรับใช่หรือไม่ ? " );
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                ServerConnecter connecter = new ServerConnecter();

                 id_parent = Integer.parseInt((String) name_place3.getText());
                 id_address = Integer.parseInt((String) name_place4.getText());
                int id_number_phone = 0;

                Log.i("data "," ID PARENT EN " + id_parent + "  ID ADDRESS EN  " + id_address);
                //Log.i("address ",""+name_place.getText());

                connecter.connect11("insert_need_list_numberphone_en.php",true,false,new Model_StatusNeed(1,id_parent,id_address,id_number_phone));

                Toast.makeText(v.getContext(),"Success Choose",Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//
//                Context context = v.getContext();
//                context.startActivity(new Intent(context, Parent_Input_Number.class));
                id_parent = Integer.parseInt((String) name_place3.getText());
                id_address = Integer.parseInt((String) name_place4.getText());
                int id_statusNeed = 1;

                Intent intent = new Intent(v.getContext(), Parent_Input_Number.class);

                intent.putExtra("id_parent",id_parent);
                intent.putExtra("id_address",id_address);
                intent.putExtra("id_statusNeed",id_statusNeed);

                v.getContext().startActivity(intent);

                dialog.dismiss();

            }
        });
        builder.show();

    }

    public int getID_Parent_EN(){
        int id_parent_EN = placeModel.getId_parent();

        return id_parent_EN;
    }

    public int getID_Address_EN(){
        int id_address_EN = placeModel.getId_address();

        return id_address_EN;
    }


}
