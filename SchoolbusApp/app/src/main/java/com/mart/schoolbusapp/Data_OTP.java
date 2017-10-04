package com.mart.schoolbusapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 21/2/2560.
 */

public class Data_OTP {

    private String otp_number;
    private int id_parent;
    private int id_student;

    public Data_OTP(String otp_number,int id_parent,int id_student) {

        this.otp_number = otp_number;
        this.id_parent = id_parent;
        this.id_student = id_student;
    }

    public Data_OTP(JSONObject jsonObj) {

        try {
            this.id_parent = jsonObj.getInt("id_parent");
            this.id_student = jsonObj.getInt("id_student");
            this.otp_number = jsonObj.getString("otp_number");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public String getOtp_number() {
        return otp_number;
    }

    public void setOtp_number(String otp_number) {
        this.otp_number = otp_number;
    }
}
