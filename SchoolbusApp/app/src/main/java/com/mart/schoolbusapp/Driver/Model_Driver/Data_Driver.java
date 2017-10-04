package com.mart.schoolbusapp.Driver.Model_Driver;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 30/11/2559.
 */

public class Data_Driver implements Parcelable{

    private int id_driver;
    private String name_driver;
    private String tel_driver;
    private String email_driver;
    private String password_driver;
    private String timestart_morning;
    private String timestart_evening;
    private String car_registration;

    public Data_Driver(String car_registration, String email_driver, int id_driver, String name_driver, String password_driver, String tel_driver, String timestart_evening, String timestart_morning) {
        this.car_registration = car_registration;
        this.email_driver = email_driver;
        this.id_driver = id_driver;
        this.name_driver = name_driver;
        this.password_driver = password_driver;
        this.tel_driver = tel_driver;
        this.timestart_evening = timestart_evening;
        this.timestart_morning = timestart_morning;
    }

    public Data_Driver(JSONObject jsonObj) {

        try {
            this.car_registration = jsonObj.getString("car_registration");
            this.email_driver = jsonObj.getString("email_driver");
            this.id_driver = jsonObj.getInt("id_driver");
            this.name_driver = jsonObj.getString("name_driver");
            this.password_driver = jsonObj.getString("password_driver");
            this.tel_driver = jsonObj.getString("tel_driver");
            this.timestart_evening = jsonObj.getString("timestart_morning");
            this.timestart_morning = jsonObj.getString("timestart_evening");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Data_Driver(Parcel in) {
        id_driver = in.readInt();
        name_driver = in.readString();
        tel_driver = in.readString();
        email_driver = in.readString();
        password_driver = in.readString();
        timestart_morning = in.readString();
        timestart_evening = in.readString();
        car_registration = in.readString();
    }

    public static final Creator<Data_Driver> CREATOR = new Creator<Data_Driver>() {
        @Override
        public Data_Driver createFromParcel(Parcel in) {
            return new Data_Driver(in);
        }

        @Override
        public Data_Driver[] newArray(int size) {
            return new Data_Driver[size];
        }
    };

    public String getCar_registration() {
        return car_registration;
    }

    public void setCar_registration(String car_registration) {
        this.car_registration = car_registration;
    }

    public String getEmail_driver() {
        return email_driver;
    }

    public void setEmail_driver(String email_driver) {
        this.email_driver = email_driver;
    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    public String getName_driver() {
        return name_driver;
    }

    public void setName_driver(String name_driver) {
        this.name_driver = name_driver;
    }

    public String getPassword_driver() {
        return password_driver;
    }

    public void setPassword_driver(String password_driver) {
        this.password_driver = password_driver;
    }

    public String getTel_driver() {
        return tel_driver;
    }

    public void setTel_driver(String tel_driver) {
        this.tel_driver = tel_driver;
    }

    public String getTimestart_evening() {
        return timestart_evening;
    }

    public void setTimestart_evening(String timestart_evening) {
        this.timestart_evening = timestart_evening;
    }

    public String getTimestart_morning() {
        return timestart_morning;
    }

    public void setTimestart_morning(String timestart_morning) {
        this.timestart_morning = timestart_morning;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_driver);
        dest.writeString(name_driver);
        dest.writeString(tel_driver);
        dest.writeString(email_driver);
        dest.writeString(password_driver);
        dest.writeString(timestart_morning);
        dest.writeString(timestart_evening);
        dest.writeString(car_registration);
    }
}
