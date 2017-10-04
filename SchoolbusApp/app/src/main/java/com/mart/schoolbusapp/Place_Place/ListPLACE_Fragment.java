package com.mart.schoolbusapp.Place_Place;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
 * Created by Mart_ on 2/1/2560.
 */

public class ListPLACE_Fragment extends Fragment implements ListPLACEAdapter.sendDataToShow,View.OnClickListener{

    private ListPLACEModel listPLACEModel;
    private ListPLACEAdapter listPLACEAdapter;
    private ListPLACEViewHolder listPLACEViewHolder;
    private ArrayList<ListPLACEModel> arrayList;
    private RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private Button btn_place;

    private OnFragmentListener mListener;

    public ListPLACE_Fragment() {
        // Required empty public constructor
    }

    public static ListPLACE_Fragment newInstance(String param1, String param2) {
        ListPLACE_Fragment fragment = new ListPLACE_Fragment();
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
    public View onCreateView(LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_place, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RCV_PLACE);

        Place p = (Place)getActivity();
        int id_parent = p.getID_PARENT_P();

        arrayList = new ArrayList<ListPLACEModel>();
        Log.i("arraylist : ",""+ arrayList);

        listPLACEAdapter = new ListPLACEAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listPLACEAdapter);

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


        btn_place = (Button)view.findViewById(R.id.btn_newPlace);
        btn_place.setVisibility(View.GONE);
        btn_place.setOnClickListener(this);


        return view;

    }

//    private ArrayList<ListPLACEModel> getMockArrayList() {
//        ArrayList<ListPLACEModel> strings = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            strings.add(new ListPLACEModel("AA"+i));
//        }
//        return strings;
//    }

    @Override
    public void sendData(ListPLACEModel model) {
        Log.i("Send data ja","");
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(),Show_PinMap.class);
        startActivity(intent);

    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);

    }
}
