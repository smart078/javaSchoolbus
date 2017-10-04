package com.mart.schoolbusapp.Parent;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 25/11/2559.
 */

public class Data_parent implements Parcelable{

    private int id_parent;
    private String name_parent;
    private String tel_parent;
    private String email_parent;
    private String password_parent;

    public Data_parent(String email_parent, int id_parent, String name_parent, String password_parent, String tel_parent) {
        this.email_parent = email_parent;
        this.id_parent = id_parent;
        this.name_parent = name_parent;
        this.password_parent = password_parent;
        this.tel_parent = tel_parent;
    }

    public Data_parent(JSONObject jsonObj) {

        try {

            this.id_parent = jsonObj.getInt("id_parent");
            this.name_parent = jsonObj.getString("name_parent");
            this.tel_parent = jsonObj.getString("tel_parent");
            this.email_parent = jsonObj.getString("email_parent");
            this.password_parent = jsonObj.getString("password_parent");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    protected Data_parent(Parcel in) {
        id_parent = in.readInt();
        name_parent = in.readString();
        tel_parent = in.readString();
        email_parent = in.readString();
        password_parent = in.readString();
    }

    public static final Creator<Data_parent> CREATOR = new Creator<Data_parent>() {
        @Override
        public Data_parent createFromParcel(Parcel in) {
            return new Data_parent(in);
        }

        @Override
        public Data_parent[] newArray(int size) {
            return new Data_parent[size];
        }
    };

    public String getEmail_parent() {
        return email_parent;
    }

    public void setEmail_parent(String email_parent) {
        this.email_parent = email_parent;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public String getName_parent() {
        return name_parent;
    }

    public void setName_parent(String name_parent) {
        this.name_parent = name_parent;
    }

    public String getPassword_parent() {
        return password_parent;
    }

    public void setPassword_parent(String password_parent) {
        this.password_parent = password_parent;
    }

    public String getTel_parent() {
        return tel_parent;
    }

    public void setTel_parent(String tel_parent) {
        this.tel_parent = tel_parent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_parent);
        dest.writeString(name_parent);
        dest.writeString(tel_parent);
        dest.writeString(email_parent);
        dest.writeString(password_parent);
    }
}
