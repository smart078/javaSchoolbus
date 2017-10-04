package com.mart.schoolbusapp.Parent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 9/12/2559.
 */

public class Data_Info_P {

    private int id_driver;
    private String name_driver;
    private String tel_driver;
    private String car_registration;

    private int id_teacher;
    private String name_teacher;
    private String tel_teacher;

    public Data_Info_P(int id_driver, int id_teacher, String name_driver, String name_teacher, String tel_driver, String tel_teacher,String car_registration) {
        this.id_driver = id_driver;
        this.id_teacher = id_teacher;
        this.name_driver = name_driver;
        this.name_teacher = name_teacher;
        this.tel_driver = tel_driver;
        this.tel_teacher = tel_teacher;
        this.car_registration = car_registration;
    }

    public Data_Info_P(JSONObject jsonObj) {

        try {

            this.id_driver = jsonObj.getInt("id_driver");
            this.name_driver = jsonObj.getString("name_driver");
            this.tel_driver = jsonObj.getString("tel_driver");
            this.id_teacher = jsonObj.getInt("id_teacher");
            this.name_teacher = jsonObj.getString("name_teacher");
            this.tel_teacher = jsonObj.getString("tel_teacher");
            this.car_registration = jsonObj.getString("car_registration");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getName_driver() {
        return name_driver;
    }

    public void setName_driver(String name_driver) {
        this.name_driver = name_driver;
    }

    public String getName_teacher() {
        return name_teacher;
    }

    public void setName_teacher(String name_teacher) {
        this.name_teacher = name_teacher;
    }

    public String getTel_driver() {
        return tel_driver;
    }

    public void setTel_driver(String tel_driver) {
        this.tel_driver = tel_driver;
    }

    public String getTel_teacher() {
        return tel_teacher;
    }

    public void setTel_teacher(String tel_teacher) {
        this.tel_teacher = tel_teacher;
    }

    public String getCar_registration() {
        return car_registration;
    }

    public void setCar_registration(String car_registration) {
        this.car_registration = car_registration;
    }
}
