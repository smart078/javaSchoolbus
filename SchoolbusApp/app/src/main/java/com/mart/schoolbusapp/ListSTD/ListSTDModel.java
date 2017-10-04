package com.mart.schoolbusapp.ListSTD;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 8/11/2559.
 */

public class ListSTDModel implements Parcelable{

    private String id_parent;
    private String id_std;
    private String std_name;
    private String std_edu;
    private String parent_name;
    private String parent_tel;
    private String status;

    public ListSTDModel(String parent_name, String parent_tel, String std_edu, String std_name, String status, String id_std) {
        this.id_std = id_std;
        this.parent_name = parent_name;
        this.parent_tel = parent_tel;
        this.std_edu = std_edu;
        this.std_name = std_name;
        this.status = status;
    }

    public ListSTDModel(String id_parent) {
        this.id_parent = id_parent;
    }

    public String getId_parent() {
        return id_parent;
    }

    public void setId_parent(String id_parent) {
        this.id_parent = id_parent;
    }

    public ListSTDModel (JSONObject jsonObj) {

        try {
            this.id_parent = jsonObj.getString("id_parent");
            this.id_std = jsonObj.getString("id_std");
            this.std_name = jsonObj.getString("std_name");
            this.std_edu = jsonObj.getString("std_edu");
            this.parent_name = jsonObj.getString("parent_name");
            this.parent_tel = jsonObj.getString("parent_tel");
            this.status = jsonObj.getString("status_student");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    protected ListSTDModel(Parcel in) {
        id_parent = in.readString();
        id_std = in.readString();
        std_name = in.readString();
        std_edu = in.readString();
        parent_name = in.readString();
        parent_tel = in.readString();
        status = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(id_parent);
        dest.writeString(id_std);
        dest.writeString(std_name);
        dest.writeString(std_edu);
        dest.writeString(parent_name);
        dest.writeString(parent_tel);
        dest.writeString(status);
    }

    public static final Creator<ListSTDModel> CREATOR = new Creator<ListSTDModel>() {
        @Override
        public ListSTDModel createFromParcel(Parcel in) {
            return new ListSTDModel(in);
        }

        @Override
        public ListSTDModel[] newArray(int size) {
            return new ListSTDModel[size];
        }
    };

    public String getId_std() {
        return id_std;
    }

    public void setId_std(String id_std) {
        this.id_std = id_std;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getParent_tel() {
        return parent_tel;
    }

    public void setParent_tel(String parent_tel) {
        this.parent_tel = parent_tel;
    }

    public String getStd_edu() {
        return std_edu;
    }

    public void setStd_edu(String std_edu) {
        this.std_edu = std_edu;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
