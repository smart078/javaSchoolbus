package com.mart.schoolbusapp.History_H_Student_Parent;

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
import com.mart.schoolbusapp.Parent.Model_Parent.Model_Infor_P;
import com.mart.schoolbusapp.Parent.Part_Parent;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Mart_ on 7/3/2560.
 */

public class ListHistoryStudentOfParent_Fragment extends Fragment {

    private ListHistory_Model listHistoryModel;
    private ListHistoryStudentOfParent_Adapter listHistoryStudentOfParentAdapter;
    private ListHistoryStudentOfParentViewHolder listHistoryStudentOfParentViewHolder;
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

        listHistoryStudentOfParentAdapter = new ListHistoryStudentOfParent_Adapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listHistoryStudentOfParentAdapter);



        History_Student_Of_Parent hsop = (History_Student_Of_Parent) getActivity();
        int id_parent = hsop.getID_PARENT();
        Log.i("ID Parent History = ",""+id_parent);

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect9("Select_History_Parent.php",true,true,new Model_Infor_P(id_parent));
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

    public static ListHistoryStudentOfParent_Fragment newInstance(String param1, String param2) {
        ListHistoryStudentOfParent_Fragment listHistoryStudentOfParent_fragment = new ListHistoryStudentOfParent_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        listHistoryStudentOfParent_fragment.setArguments(args);
        return listHistoryStudentOfParent_fragment;
    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);

    }

}
