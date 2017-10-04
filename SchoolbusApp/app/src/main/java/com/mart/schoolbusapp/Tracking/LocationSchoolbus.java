package com.mart.schoolbusapp.Tracking;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mart_ on 11/2/2560.
 */

public class LocationSchoolbus implements Serializable {

    @SerializedName("id_location")
    private int id_location;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longtitude")
    private double longtitude;

    public LocationSchoolbus(){

    }

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
}
