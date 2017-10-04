package com.mart.schoolbusapp.Parent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 10/12/2559.
 */

public class Data_STD_P {

    private int id_student;
    private String name_student;
    private String education_student;
    private String status_std ;


    public Data_STD_P(String education_student, int id_student, String name_student, String status_std) {
        this.education_student = education_student;
        this.id_student = id_student;
        this.name_student = name_student;
        this.status_std = status_std;
    }

    public Data_STD_P(JSONObject jsonObj) {

        try {

            this.id_student = jsonObj.getInt("id_student");
            this.name_student = jsonObj.getString("name_student");
            this.education_student = jsonObj.getString("education_student");
            this.status_std = jsonObj.getString("status_std");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getEducation_student() {
        return education_student;
    }

    public void setEducation_student(String education_student) {
        this.education_student = education_student;
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

    public String getStatus_std() {
        return status_std;
    }

    public void setStatus_std(String status_std) {
        this.status_std = status_std;
    }
}
