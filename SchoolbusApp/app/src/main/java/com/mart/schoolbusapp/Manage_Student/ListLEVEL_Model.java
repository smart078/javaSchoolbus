package com.mart.schoolbusapp.Manage_Student;

import org.json.JSONException;
import org.json.JSONObject;

public class ListLEVEL_Model {

    private String name_student;
    private String address_student;
    private String latitude;
    private String longitude;

    public ListLEVEL_Model(String address_student, String latitude, String longitude, String name_student) {
        this.address_student = address_student;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name_student = name_student;
    }

    public ListLEVEL_Model (JSONObject jsonObj) {
        try {
            this.name_student = jsonObj.getString("name_student");
            this.address_student = jsonObj.getString("description");
            this.latitude = jsonObj.getString("latitude");
            this.longitude = jsonObj.getString("longitude");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getAddress_student() {
        return address_student;
    }

    public void setAddress_student(String address_student) {
        this.address_student = address_student;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }
}
