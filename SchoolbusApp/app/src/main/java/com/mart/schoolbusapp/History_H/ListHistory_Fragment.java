package com.mart.schoolbusapp.History_H;

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

import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class ListHistory_Fragment extends Fragment {

    private ListHistory_Model listHistoryModel;
    private ListHistory_Adapter listHistoryAdapter;
    private ListHistoryViewHolder listHistoryViewHolder;
    private ArrayList<ListHistory_Model> arrayList;
    private RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_history, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RCV_HISTORY_LIST);

        arrayList = new ArrayList<ListHistory_Model>();
        Log.i("arraylist : ",""+ arrayList);

        listHistoryAdapter = new ListHistory_Adapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listHistoryAdapter);

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect("Select_History_All.php",false,true,null);
        JSONArray arr = connector.getResponseArray(re);
        Log.i("ARR : ",""+ arr);
        Log.i("ARR COUNT : ",""+ arr.length());

        for(int i=0;i<arr.length();i++) {

            Log.i("I : ",""+ i);

            try {
                arrayList.add(new ListHistory_Model(arr.getJSONObject(i)));
                Log.i("arraylist 1 : ",""+ arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return view;

    }

    public static ListHistory_Fragment newInstance(String param1, String param2) {
        ListHistory_Fragment listHistory_fragment = new ListHistory_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        listHistory_fragment.setArguments(args);
        return listHistory_fragment;
    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);

    }

}
