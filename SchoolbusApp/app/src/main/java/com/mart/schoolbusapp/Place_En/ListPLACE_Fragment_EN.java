package com.mart.schoolbusapp.Place_En;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mart.schoolbusapp.Place_Place.ListPLACEModel;
import com.mart.schoolbusapp.Place_Place.Model_Parent_Need_MN;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Mart_ on 16/1/2560.
 */

public class ListPLACE_Fragment_EN extends Fragment implements ListPLACEAdapter_EN.sendDataToShow,View.OnClickListener {

    private ListPLACEModel listPLACEModel;
    private ListPLACEAdapter_EN listPLACEAdapter_en;
    private ListPLACEViewHolder_EN listPLACEViewHolder_en;
    private ArrayList<ListPLACEModel> arrayList;
    private RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private Button btn_place_en;

    private OnFragmentListener mListener;

    public ListPLACE_Fragment_EN() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_place_en, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RCV_PLACE_EN);

        Place_En p = (Place_En)getActivity();
        int id_parent = p.getID_PARENT_P_EN();

        arrayList = new ArrayList<ListPLACEModel>();
        Log.i("arraylist : ",""+ arrayList);

        listPLACEAdapter_en = new ListPLACEAdapter_EN(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listPLACEAdapter_en);

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect19("getListPLACE.php",true,true,new Model_Parent_Need_MN(id_parent));
        JSONArray arr = connector.getResponseArray(re);
        Log.i("ARR : ",""+ arr);
        Log.i("ARR COUNT : ",""+ arr.length());

        for(int i=0;i<arr.length();i++) {

            Log.i("I : ",""+ i);

            try {
                arrayList.add(new ListPLACEModel(arr.getJSONObject(i)));
                Log.i("arraylist 1 : ",""+ arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        btn_place_en = (Button)view.findViewById(R.id.btn_newPlace_EN);
        btn_place_en.setVisibility(View.GONE);
        btn_place_en.setOnClickListener(this);

        return view;
    }

    public static ListPLACE_Fragment_EN newInstance(String param1, String param2) {
        ListPLACE_Fragment_EN fragment_en = new ListPLACE_Fragment_EN();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment_en.setArguments(args);
        return fragment_en;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(),Show_PinMap_EN.class);
        startActivity(intent);

    }

    @Override
    public void sendData(ListPLACEModel model) {

    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);

    }
}
