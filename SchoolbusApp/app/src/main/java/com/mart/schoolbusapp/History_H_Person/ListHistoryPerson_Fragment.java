package com.mart.schoolbusapp.History_H_Person;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mart.schoolbusapp.History_H.ListHistory_Model;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class ListHistoryPerson_Fragment extends Fragment {

    private ListHistory_Model listHistoryModel;
    private ListHistoryPerson_Adapter listHistoryPersonAdapter;
    private ListHistoryPersonViewHolder listHistoryPersonViewHolder;
    private ArrayList<ListHistory_Model> arrayList;
    private RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_history, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RCV_HISTORY_LIST);

        arrayList = new ArrayList<ListHistory_Model>();
        Log.i("arraylist : ",""+ arrayList);

        listHistoryPersonAdapter = new ListHistoryPerson_Adapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listHistoryPersonAdapter);


        History_Person history_person = (History_Person) getActivity();
        int id_student = history_person.getID_STUDENT();
        Log.i("ID student",""+id_student);

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect17("Select_History_Person.php",true,true,new Entity_ListHistoryPerson(id_student));
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

    public static ListHistoryPerson_Fragment newInstance(String param1, String param2) {
        ListHistoryPerson_Fragment listHistoryPerson_fragment = new ListHistoryPerson_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        listHistoryPerson_fragment.setArguments(args);
        return listHistoryPerson_fragment;
    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);

    }


}
