package com.mart.schoolbusapp.Place_Place;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 2/1/2560.
 */

public class ListPLACEModel {

    private int id_parent;
    private int id_address;

    private String description;
    private String number_village;
    private String soi;
    private String road;
    private String subdistrict;
    private String district;
    private String province;
    private String number_post;
    private String name_parent;


    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public ListPLACEModel(String district, String number_post, String number_village,
                          String description, String province, String road, String soi, String subdistrict,
                          int id_address, int id_parent, String name_parent) {
        this.district = district;
        this.number_post = number_post;
        this.number_village = number_village;
        this.description = description;
        this.province = province;
        this.road = road;
        this.soi = soi;
        this.subdistrict = subdistrict;
        this.id_address = id_address;
        this.id_parent = id_parent;
        this.name_parent = name_parent;
    }

    public ListPLACEModel (JSONObject jsonObj) {

        try {
            this.id_parent = jsonObj.getInt("id_parent");
            this.id_address = jsonObj.getInt("id_address");
            this.district = jsonObj.getString("district");
            this.number_post = jsonObj.getString("number_post");
            this.number_village = jsonObj.getString("number_village");
            this.description = jsonObj.getString("description");
            this.province = jsonObj.getString("province");
            this.road = jsonObj.getString("road");
            this.soi = jsonObj.getString("soi");
            this.subdistrict = jsonObj.getString("subdistrict");
            this.name_parent = jsonObj.getString("name_parent");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getName_parent() {
        return name_parent;
    }

    public void setName_parent(String name_parent) {
        this.name_parent = name_parent;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNumber_post() {
        return number_post;
    }

    public void setNumber_post(String number_post) {
        this.number_post = number_post;
    }

    public String getNumber_village() {
        return number_village;
    }

    public void setNumber_village(String number_village) {
        this.number_village = number_village;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }
}
