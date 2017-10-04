package com.mart.schoolbusapp;

import android.content.Context;
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

import com.mart.schoolbusapp.ListSTD.ListSTDAdapter;
import com.mart.schoolbusapp.ListSTD.ListSTDModel;
import com.mart.schoolbusapp.ListSTD.ListSTDViewHolder;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Mart_ on 1/12/2559.
 */

public class ListMN_Fragment extends Fragment implements ListSTDAdapter.sendDataToShow{

    private ListSTDAdapter listSTDAdapter;
    private ListSTDViewHolder listSTDViewHolder;
    private ListSTDModel listSTDModel;
    private ArrayList<ListSTDModel> arrayList;
    private RecyclerView rcy;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListMN_Fragment() {

    }

    public static ListMN_Fragment newInstance(String param1, String param2) {
        ListMN_Fragment fragment = new ListMN_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_morning, container, false);

        rcy = (RecyclerView)view.findViewById(R.id.RCV_MN);

        arrayList = new ArrayList<ListSTDModel>();
        Log.i("arraylist : ",""+ arrayList);

        listSTDAdapter = new ListSTDAdapter(arrayList);
        listSTDAdapter.setCallback(this);

        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
        rcy.setAdapter(listSTDAdapter);

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect("getListSTD_morning.php",false,true,null);
        JSONArray arr = connector.getResponseArray(re);
        Log.i("ARR : ",""+ arr);
        Log.i("ARR COUNT : ",""+ arr.length());

        for(int i=0;i<arr.length();i++) {

            Log.i("I : ",""+ i);

            try {
                arrayList.add(new ListSTDModel(arr.getJSONObject(i)));
                Log.i("arraylist 1 : ",""+ arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void sendData(ListSTDModel listSTDModel) {
        Log.i("SEND DATA CLICK: ","");
        Intent intent = new Intent(getContext(), Status_Student.class);
        intent.putExtra("DATA", listSTDModel);
        startActivity(intent);

    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
