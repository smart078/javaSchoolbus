package com.mart.schoolbusapp.NumberPhone_Parent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 18/1/2560.
 */

public class Number_Phone extends FragmentActivity {

     String address;
     String city;
     String state;
     String country;
     String postalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_phone);



        Log.i("Address Description "," Description : " + address + " " + city + " " + state +" " + country + " " + postalCode + " ");

        ListNumber_Fragment_EN listNumber_fragment_en = new ListNumber_Fragment_EN();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_number, listNumber_fragment_en, ListNumber_Fragment_EN.class.getSimpleName());
        fragmentTransaction.commit();


    }

    public String getAddress_Address(){

        address = getIntent().getStringExtra("address_a");
        city = getIntent().getStringExtra("city_c");
        state = getIntent().getStringExtra("state_s");
        country = getIntent().getStringExtra("country_c");
        postalCode = getIntent().getStringExtra("postalCode_p");

        String addressPut = address+" "+city+" "+state+" "+country+" "+postalCode;

        return addressPut;

    }

}
