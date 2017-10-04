package com.mart.schoolbusapp.Teacher;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 28/11/2559.
 */

public class Data_Teacher implements Parcelable {

    private int id_teacher;
    private String name_teacher;
    private String tel_teacher;
    private String email_teacher;
    private String password_teacher;

    public Data_Teacher(String email_teacher, int id_teacher, String name_teacher, String password_teacher, String tel_teacher) {
        this.email_teacher = email_teacher;
        this.id_teacher = id_teacher;
        this.name_teacher = name_teacher;
        this.password_teacher = password_teacher;
        this.tel_teacher = tel_teacher;
    }

    public Data_Teacher(JSONObject jsonObj) {

        try {

            this.id_teacher = jsonObj.getInt("id_teacher");
            this.name_teacher = jsonObj.getString("name_teacher");
            this.tel_teacher = jsonObj.getString("tel_teacher");
            this.email_teacher = jsonObj.getString("email_teacher");
            this.password_teacher = jsonObj.getString("password_teacher");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    protected Data_Teacher(Parcel in) {
        id_teacher = in.readInt();
        name_teacher = in.readString();
        tel_teacher = in.readString();
        email_teacher = in.readString();
        password_teacher = in.readString();
    }

    public static final Creator<Data_Teacher> CREATOR = new Creator<Data_Teacher>() {
        @Override
        public Data_Teacher createFromParcel(Parcel in) {
            return new Data_Teacher(in);
        }

        @Override
        public Data_Teacher[] newArray(int size) {
            return new Data_Teacher[size];
        }
    };

    public String getEmail_teacher() {
        return email_teacher;
    }

    public void setEmail_teacher(String email_teacher) {
        this.email_teacher = email_teacher;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getName_teacher() {
        return name_teacher;
    }

    public void setName_teacher(String name_teacher) {
        this.name_teacher = name_teacher;
    }

    public String getPassword_teacher() {
        return password_teacher;
    }

    public void setPassword_teacher(String password_teacher) {
        this.password_teacher = password_teacher;
    }

    public String getTel_teacher() {
        return tel_teacher;
    }

    public void setTel_teacher(String tel_teacher) {
        this.tel_teacher = tel_teacher;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_teacher);
        dest.writeString(name_teacher);
        dest.writeString(tel_teacher);
        dest.writeString(email_teacher);
        dest.writeString(password_teacher);
    }
}
