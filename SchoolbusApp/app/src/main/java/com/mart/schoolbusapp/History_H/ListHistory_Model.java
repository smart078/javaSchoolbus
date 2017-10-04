package com.mart.schoolbusapp.History_H;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class ListHistory_Model {

    private String time_date;
    private String period;
    private String name_student;
    private String status_student;

    private int id_student;

    public ListHistory_Model(String name_student, String period, String status_student, String time_date) {
        this.name_student = name_student;
        this.period = period;
        this.status_student = status_student;
        this.time_date = time_date;
    }

    public ListHistory_Model(int id_student) {
        this.id_student = id_student;
    }

    public ListHistory_Model (JSONObject jsonObj) {
        try {
            this.name_student = jsonObj.getString("name_student");
            this.time_date = jsonObj.getString("time_date");
            this.period = jsonObj.getString("name_period");
            this.status_student = jsonObj.getString("status_std");

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

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStatus_student() {
        return status_student;
    }

    public void setStatus_student(String status_student) {
        this.status_student = status_student;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
