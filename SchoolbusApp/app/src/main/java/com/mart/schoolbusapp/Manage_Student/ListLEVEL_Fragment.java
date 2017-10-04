package com.mart.schoolbusapp.Manage_Student;

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

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mart_ on 8/2/2560.
 */

public class ListLEVEL_Fragment extends Fragment  {

    private ListLEVEL_Model listLEVELModel;
    private ListLEVEL_Adapter listLEVELAdapter;
    private ListLEVELViewHolder listLEVELViewHolder;
    private ArrayList<ListLEVEL_Model> arrayList;
    private RecyclerView recyclerView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private String address0, address1, address2, address3, address4, address5, address6, address7, address8, address9;
    private String name0, name1, name2, name3, name4, name5, name6, name7, name8, name9;
    private double lat0, lat1, lat2, lat3, lat4, lat5, lat6, lat7, lat8, lat9;
    private double long0, long1, long2, long3, long4, long5, long6, long7, long8, long9;
    private double distance1, distance2, distance3, distance4, distance5, distance6, distance7, distance8, distance9, distance10;

    private static final DateFormat sdf = new SimpleDateFormat("H");

    private OnFragmentListener mListener;

    public ListLEVEL_Fragment() {
        // Required empty public constructor
    }

    public static ListLEVEL_Fragment newInstance(String param1, String param2) {
        ListLEVEL_Fragment listLEVEL_fragment = new ListLEVEL_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        listLEVEL_fragment.setArguments(args);
        return listLEVEL_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private JSONArray arr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_manage, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.RCV_DRIVER_LIST);

        Date date = new Date();
        String hour = sdf.format(date);
        //int hh = Integer.parseInt(hour);
        //int hh = 5;
        int hh = 16; //this time is
        LatLng start = null;
        if (hh >= 0 && hh <= 12){
            start = new LatLng(13.617308,100.641696);
            Log.i("mornning ",""+hh);
        }else if (hh >= 13 && hh <= 24){
            start = new LatLng(13.6575868,100.6295842);
            Log.i("evening ",""+hh);
        }else {
            Log.i("undifine ",""+hh);
        }

        ServerConnecter connector = new ServerConnecter();
        String re = connector.connect("select_identifyNeed_EN.php",false,true,null);
        arr = connector.getResponseArray(re);
        Log.i("ARR : ",""+ arr);
        Log.i("ARR COUNT : ",""+ arr.length());

        double last = (arr.length())-1;

        arrayList = new ArrayList<ListLEVEL_Model>();

        for(int i=0;i<arr.length();i++) {
            Log.i("I : ",""+ i);
            try {
                listLEVELModel = new ListLEVEL_Model(arr.getJSONObject(i));
                if (i==0){
                    lat0 = Double.parseDouble(listLEVELModel.getLatitude());
                    long0 = Double.parseDouble(listLEVELModel.getLongitude());
                    address0 = listLEVELModel.getAddress_student();
                    name0 = listLEVELModel.getName_student();
                    Log.i("lat long 0 ",""+lat0+long0);

                }else if (i==1){
                    lat1 = Double.parseDouble(listLEVELModel.getLatitude());
                    long1 = Double.parseDouble(listLEVELModel.getLongitude());
                    address1 = listLEVELModel.getAddress_student();
                    name1 = listLEVELModel.getName_student();
                    Log.i("lat long 1 ",""+lat1+long1);
                }else if (i==2){
                    lat2 = Double.parseDouble(listLEVELModel.getLatitude());
                    long2 = Double.parseDouble(listLEVELModel.getLongitude());
                    address2 = listLEVELModel.getAddress_student();
                    name2 = listLEVELModel.getName_student();
                    Log.i("lat long 2 ",""+lat2+long2);

                }else if (i==3){
                    lat3 = Double.parseDouble(listLEVELModel.getLatitude());
                    long3 = Double.parseDouble(listLEVELModel.getLongitude());
                    address3 = listLEVELModel.getAddress_student();
                    name3 = listLEVELModel.getName_student();
                    Log.i("lat long 3 ",""+lat3+long3);

                }else if (i==4){
                    lat4 = Double.parseDouble(listLEVELModel.getLatitude());
                    long4 = Double.parseDouble(listLEVELModel.getLongitude());
                    address4 = listLEVELModel.getAddress_student();
                    name4 = listLEVELModel.getName_student();
                    Log.i("lat long 4 ",""+lat4+long4);

                }else if (i==5){
                    lat5 = Double.parseDouble(listLEVELModel.getLatitude());
                    long5 = Double.parseDouble(listLEVELModel.getLongitude());
                    address5 = listLEVELModel.getAddress_student();
                    name5 = listLEVELModel.getName_student();
                    Log.i("lat long 5 ",""+lat5+long5);

                }else if (i==6){
                    lat6 = Double.parseDouble(listLEVELModel.getLatitude());
                    long6 = Double.parseDouble(listLEVELModel.getLongitude());
                    address6 = listLEVELModel.getAddress_student();
                    name6 = listLEVELModel.getName_student();
                    Log.i("lat long 6 ",""+lat6+long6);

                }else if (i==7){
                    lat7 = Double.parseDouble(listLEVELModel.getLatitude());
                    long7 = Double.parseDouble(listLEVELModel.getLongitude());
                    address7 = listLEVELModel.getAddress_student();
                    name7 = listLEVELModel.getName_student();
                    Log.i("lat long 7 ",""+lat7+long7);

                }else if (i==8){
                    lat8 = Double.parseDouble(listLEVELModel.getLatitude());
                    long8 = Double.parseDouble(listLEVELModel.getLongitude());
                    address8 = listLEVELModel.getAddress_student();
                    name8 = listLEVELModel.getName_student();
                    Log.i("lat long 8 ",""+lat8+long8);

                }else if (i==9){
                    lat9 = Double.parseDouble(listLEVELModel.getLatitude());
                    long9 = Double.parseDouble(listLEVELModel.getLongitude());
                    address9 = listLEVELModel.getAddress_student();
                    name9 = listLEVELModel.getName_student();
                    Log.i("lat long 9 ",""+lat9+long9);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.i("List leval adapter"," "+listLEVELModel);

        if (lat0 != 0.0 && long0 != 0.0){
            LatLng to1 = new LatLng(lat0, long0);
            distance1 = SphericalUtil.computeDistanceBetween(start, to1);
        }
        if (lat1 != 0.0 && long1 != 0.0){
            LatLng to2 = new LatLng(lat1, long1);
            distance2 = SphericalUtil.computeDistanceBetween(start, to2);
        }
        if (lat2 != 0.0 && long2 != 0.0){
            LatLng to3 = new LatLng(lat2, long2);
            distance3 = SphericalUtil.computeDistanceBetween(start, to3);
        }
        if (lat3 != 0.0 && long3 != 0.0){
            LatLng to4 = new LatLng(lat3, long3);
            distance4 = SphericalUtil.computeDistanceBetween(start, to4);

        }
        if (lat4 != 0.0 && long4 != 0.0){
            LatLng to5 = new LatLng(lat4, long4);
            distance5 = SphericalUtil.computeDistanceBetween(start, to5);

        }
        if (lat5 != 0.0 && long5 != 0.0){
            LatLng to6 = new LatLng(lat5, long5);
            distance6 = SphericalUtil.computeDistanceBetween(start, to6);

        }
        if (lat6 != 0.0 && long6 != 0.0){
            LatLng to7 = new LatLng(lat6, long6);
            distance7 = SphericalUtil.computeDistanceBetween(start, to7);

        }
        if (lat7 != 0.0 && long7 != 0.0){
            LatLng to8 = new LatLng(lat7, long7);
            distance8 = SphericalUtil.computeDistanceBetween(start, to8);

        }
        if (lat8 != 0.0 && long8 != 0.0){
            LatLng to9 = new LatLng(lat8, long8);
            distance9 = SphericalUtil.computeDistanceBetween(start, to9);

        }
        if (lat9 != 0.0 && long9 != 0.0){
            LatLng to10 = new LatLng(lat9, long9);
            distance10 = SphericalUtil.computeDistanceBetween(start, to10);
        }

        cal();

        listLEVELAdapter = new ListLEVEL_Adapter(strings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listLEVELAdapter);

        return view;
    }

    public interface OnFragmentListener {
        void onFragmentInteractionPLACE(Uri uri);
    }

    private int num0 ,num1 ,num2 ,num3 ,num4 ,num5 ,num6 ,num7 ,num8 ,num9 ;

    List<Double> distance = new ArrayList<>();

    List<String> checkValue0 = new ArrayList<>();
    List<String> checkValue1 = new ArrayList<>();
    List<String> checkValue2 = new ArrayList<>();
    List<String> checkValue3 = new ArrayList<>();
    List<String> checkValue4 = new ArrayList<>();
    List<String> checkValue5 = new ArrayList<>();
    List<String> checkValue6 = new ArrayList<>();
    List<String> checkValue7 = new ArrayList<>();
    List<String> checkValue8 = new ArrayList<>();
    List<String> checkValue9 = new ArrayList<>();

    private void cal (){

        if (distance1 != 0.0){distance.add(distance1); }
        if (distance2 != 0.0){distance.add(distance2);}
        if (distance3 != 0.0){distance.add(distance3); }
        if (distance4 != 0.0){distance.add(distance4);}
        if (distance5 != 0.0){distance.add(distance5); }
        if (distance6 != 0.0){distance.add(distance6);}
        if (distance7 != 0.0){distance.add(distance7); }
        if (distance8 != 0.0){distance.add(distance8);}
        if (distance9 != 0.0){distance.add(distance9); }
        if (distance10 != 0.0){distance.add(distance10);}


        double last = (distance.size())-1;
        Log.i("Distance :last",""+last);
        Log.i("Distance size",""+distance.size());

        for (int i = 0; i<distance.size(); i++){
            double indexx = distance.get(i);
            Log.i("Distance : indexx ",""+indexx);

            if (i==0){
                Log.i("Distance : indexx "," == 0");
                int ant = 1;
                while (ant <= last){
                    Log.i("i==0 ","indexx : "+indexx);
                    if (indexx<=distance.get(ant)){
                        Log.i("i==0 T ","distance : "+distance.get(ant));
                        checkValue0.add("True");
                        ant++;
                    }else {
                        Log.i("i==0 F ","distance : "+distance.get(ant));
                        checkValue0.add("False");
                        ant++;
                    }
                }
            }else if (i==last){
                Log.i("Distance : indexx "," == last");
                int bird = 0;
                while (bird < last){
                    Log.i("i==last ","indexx : "+indexx);
                    if (indexx<=distance.get(bird)){
                        Log.i("i==last T ","distance : "+distance.get(bird));
                        checkValue9.add("True");
                        bird++;
                    }else {
                        Log.i("i==last F ","distance : "+distance.get(bird));
                        checkValue9.add("False");
                        bird++;
                    }
                }
            }else {
                Log.i("Distance : indexx "," == "+i);
                List<String> checkValue = new ArrayList<>();

                int cat = 1;
                int dog = 0;

                int ear = (distance.size()-1)-i;
                int fish = i+1;
                int gogo = 1;

                while (cat <= i){
                    Log.i("c vs d ","indexx : "+indexx);
                    if (indexx<=distance.get(dog)){
                        Log.i("c vs d ","T distance : "+distance.get(dog));
                        checkValue.add("True");
                        dog++;
                        cat++;
                    }else {
                        Log.i("c vs d ","F distance : "+distance.get(dog));
                        checkValue.add("False");
                        dog++;
                        cat++;
                    }
                }
                while (gogo <= ear){
                    Log.i("f vs e ","indexx : "+indexx);
                    if (indexx<=distance.get(fish)){
                        Log.i("f vs e ","T distance : "+distance.get(fish));
                        checkValue.add("True");
                        fish++;
                        gogo++;
                    }else {
                        Log.i("f vs e ","F distance : "+distance.get(fish));
                        checkValue.add("False");
                        fish++;
                        gogo++;
                    }
                }
                Log.i("ARRAY "+i,""+checkValue);
                if (i==1){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue1.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue1);
                }else if (i==2){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue2.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue2);
                }else if (i==3){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue3.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue3);
                }else if (i==4){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue4.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue4);
                }else if (i==5){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue5.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue5);
                }else if (i==6){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue6.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue6);
                }else if (i==7){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue7.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue7);
                }else if (i==8){
                    for (int tik =0; tik<checkValue.size(); tik++){
                        checkValue8.add(tik,checkValue.get(tik));
                    }
                    Log.i("value array "+i,""+checkValue8);
                }
            }
        }

        Log.i("check value 0",""+checkValue0.size());
        Log.i("check value 1",""+checkValue1.size());
        Log.i("check value 2",""+checkValue2.size());
        Log.i("check value 3",""+checkValue3.size());
        Log.i("check value 4",""+checkValue4.size());
        Log.i("check value 5",""+checkValue5.size());
        Log.i("check value 6",""+checkValue6.size());
        Log.i("check value 7",""+checkValue7.size());
        Log.i("check value 8",""+checkValue8.size());
        Log.i("check value 9",""+checkValue9.size());

        if (checkValue0.isEmpty()) {
            Log.i("checkValue0 is null ","");
            num0 =99;

        }else{
            Log.i("check value 0"," not null checking false"+checkValue0.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue0.size()-1); p >= 0; p--) {
                if (checkValue0.get(p) == "False") {
                    idxs.add(m,"F");
                }
            }
            num0 = idxs.size();
            Log.i("0 false size : ",""+num0);
        }
        if (checkValue1.isEmpty()) {
            Log.i("checkValue1 is null ","");
            num1 =99;

        }else{
            Log.i("check value 1"," not null checking false"+checkValue1.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue1.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue1.get(p));
                if (checkValue1.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num1 = idxs.size();
            Log.i("1 false size : ",""+num1);
        }
        if (checkValue2.isEmpty()) {
            Log.i("checkValue2 is null ","");
            num2 =99;

        }else{
            Log.i("check value 2"," not null checking false"+checkValue2.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue2.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue2.get(p));
                if (checkValue2.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num2 = idxs.size();
            Log.i("2 false size : ",""+num2);
        }
        if (checkValue3.isEmpty()) {
            Log.i("checkValue3 is null ","");
            num3 =99;

        }else{
            Log.i("check value 3"," not null checking false"+checkValue3.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue3.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue3.get(p));
                if (checkValue3.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num3 = idxs.size();
            Log.i("3 false size : ",""+num3);
        }
        if (checkValue4.isEmpty()) {
            Log.i("checkValue4 is null ","");
            num4 =99;

        }else{
            Log.i("check value 4"," not null checking false"+checkValue4.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue4.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue4.get(p));
                if (checkValue4.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num4 = idxs.size();
            Log.i("4 false size : ",""+num4);
        }
        if (checkValue5.isEmpty()) {
            Log.i("checkValue5 is null ","");
            num5 =99;

        }else{
            Log.i("check value 5"," not null checking false"+checkValue5.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue5.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue5.get(p));
                if (checkValue5.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num5 = idxs.size();
            Log.i("5 false size : ",""+num5);
        }
        if (checkValue6.isEmpty()) {
            Log.i("checkValue6 is null ","");
            num6 =99;

        }else{
            Log.i("check value 6"," not null checking false"+checkValue6.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue6.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue6.get(p));
                if (checkValue6.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num6 = idxs.size();
            Log.i("6 false size : ",""+num6);
        }
        if (checkValue7.isEmpty()) {
            Log.i("checkValue7 is null ","");
            num7 =99;

        }else{
            Log.i("check value 7"," not null checking false"+checkValue7.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue7.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue7.get(p));
                if (checkValue7.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num7 = idxs.size();
            Log.i("7 false size : ",""+num7);
        }
        if (checkValue8.isEmpty()) {
            Log.i("checkValue8 is null ","");
            num8 =99;

        }else{
            Log.i("check value 8"," not null checking false"+checkValue8.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue8.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue8.get(p));
                if (checkValue8.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num8 = idxs.size();
            Log.i("8 false size : ",""+num8);
        }
        if (checkValue9.isEmpty()) {
            Log.i("checkValue9 is null ","");
            num9 = 99;

        }else{
            Log.i("check value 9"," not null checking false"+checkValue9.size());
            List<String> idxs = new ArrayList<>();
            int m = 0;
            for (int p = (checkValue9.size()-1); p >= 0; p--) {
                Log.i("p : "+p,""+checkValue9.get(p));
                if (checkValue9.get(p) == "False") {
                    idxs.add(m,"F");
                    m++;
                }
            }
            num9 = idxs.size();
            Log.i("9 false size : ",""+num9);
        }
        manageLevel();
    }

    ArrayList<ListLEVEL_Model> strings = new ArrayList<>();

    private void manageLevel (){
        int num = 0;
        int level = distance.size()-1;
        while (num < distance.size()){

            //Log.i("level :",""+level);//4
            Log.i("num :",""+num);//0
            Log.i("num0 :",""+num0);//4
            Log.i("num1 :",""+num1);//3
            Log.i("num2 :",""+num2);//2
            Log.i("num3 :",""+num3);//1
            Log.i("num4 :",""+num4);//0
            Log.i("num5 :",""+num5);
            Log.i("num6 :",""+num6);
            Log.i("num7 :",""+num7);
            Log.i("num8 :",""+num8);
            Log.i("num9 :",""+num9);

            if (num0 != 99 && num0 == num){
                strings.add(num,(new ListLEVEL_Model(address0,lat0+"",long0+"",""+name0)));
                Log.i("Level "+num," is num 0"+address0);
                num++;
            }else if (num1 != 99 && num1 == num){
                strings.add(num,(new ListLEVEL_Model(address1,lat1+"",long1+"",""+name1)));
                Log.i("Level "+num," is num 1"+address1);
                num++;
            }else if (num2 != 99 && num2 == num){
                strings.add(num,(new ListLEVEL_Model(address2,lat2+"",long2+"",""+name2)));
                Log.i("Level "+num," is num 2"+address2);
                num++;
            }else if (num3 != 99 && num3 == num){
                strings.add(num,(new ListLEVEL_Model(address3,lat3+"",long3+"",""+name3)));
                Log.i("Level "+num," is num 3"+address3);
                num++;
            }else if (num4 != 99 && num4 == num){
                strings.add(num,(new ListLEVEL_Model(address4,lat4+"",long4+"",""+name4)));
                Log.i("Level "+num," is num 4"+address4);
                num++;
            }else if (num5 != 99 && num5 == num){
                strings.add(num,(new ListLEVEL_Model(address5,lat5+"",long5+"",""+name5)));
                Log.i("Level "+num," is num 5"+address5);
                num++;
            }else if (num6 != 99 && num6 == num){
                strings.add(num,(new ListLEVEL_Model(address6,lat6+"",long6+"",""+name6)));
                Log.i("Level "+num," is num 6"+address6);
                num++;
            }else if (num7 != 99 && num7 == num){
                strings.add(num,(new ListLEVEL_Model(address7,lat7+"",long7+"",""+name7)));
                Log.i("Level "+num," is num 7"+address7);
                num++;
            }else if (num8 != 99 && num8 == num){
                strings.add(num,(new ListLEVEL_Model(address8,lat8+"",long8+"",""+name8)));
                Log.i("Level "+num," is num 8"+address8);
                num++;
            }else if (num9 != 99 && num9 == num){
                strings.add(num,(new ListLEVEL_Model(address9,lat9+"",long9+"",""+name9)));
                Log.i("Level "+num," is num 9"+address9);
                num++;
            }else {
                Log.i("Level "+level," is Not found");
                num++;
            }
        }
    }
}
