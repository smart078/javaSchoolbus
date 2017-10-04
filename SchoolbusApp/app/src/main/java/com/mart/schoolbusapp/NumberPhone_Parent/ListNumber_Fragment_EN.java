package com.mart.schoolbusapp.NumberPhone_Parent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Mart_ on 17/1/2560.
 */

public class ListNumber_Fragment_EN extends Fragment implements ListNumberAdapter.sendDataToShow,View.OnClickListener {

    private ListNumberModel listNumberModel;
    private ListNumberAdapter listNumberAdapter;
    private ListNumberViewHolder listNumberViewHolder;
    private ArrayList<ListNumberModel> arrayList;
    private RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private String address;

    private Button btn_new_number;

    private OnFragmentListener mListener;

    public ListNumber_Fragment_EN() {
        // Required empty public constructor
    }

    public static ListNumber_Fragment_EN newInstance(String param1, String param2) {
        ListNumber_Fragment_EN listNumber_fragment_en = new ListNumber_Fragment_EN();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        listNumber_fragment_en.setArguments(args);
        return listNumber_fragment_en;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_numparent, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RCV_NUM_PARENT);


        Number_Phone yo = (Number_Phone) getActivity();
        address = yo.getAddress_Address();
        Log.i(" Address : ",""+address);

        arrayList = new ArrayList<ListNumberModel>();
        Log.i("arraylist : ",""+ arrayList);

        listNumberAdapter = new ListNumberAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listNumberAdapter);

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect("getNumber_Phone.php",false,true,null);
        JSONArray arr = connector.getResponseArray(re);
        Log.i("ARR : ",""+ arr);
        Log.i("ARR COUNT : ",""+ arr.length());

        for(int i=0;i<arr.length();i++) {

            Log.i("I : ",""+ i);

            try {
                arrayList.add(new ListNumberModel(arr.getJSONObject(i)));
                Log.i("arraylist 1 : ",""+ arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        btn_new_number = (Button)view.findViewById(R.id.btn_num_parent);
        btn_new_number.setOnClickListener(this);

        return view;

    }

    @Override
    public void sendData(ListNumberModel model) {

        Log.i("Send data","");

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(),Input_Number_Parent.class);

        intent.putExtra("address",address);

        startActivity(intent);

    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);

    }
}
