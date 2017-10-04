package com.mart.schoolbusapp.NumberPhone_Parent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 17/1/2560.
 */

public class ListNumberModel {

    private String phone_number;
    private String phone_name;
    private String otp_number;

    public ListNumberModel(String phone_number, String phone_name ,String otp_number) {

        this.phone_number = phone_number;
        this.phone_name = phone_name;
        this.otp_number = otp_number;

    }

    public ListNumberModel (JSONObject jsonObj) {

        try {
            this.phone_number = jsonObj.getString("phone_number");
            this.phone_name = jsonObj.getString("phone_name");
            //this.otp_number = jsonObj.getString("otp_name");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
