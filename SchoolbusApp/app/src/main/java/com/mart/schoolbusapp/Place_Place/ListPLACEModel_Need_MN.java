package com.mart.schoolbusapp.Place_Place;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 12/3/2560.
 */

public class ListPLACEModel_Need_MN {

    private String name_parent,description;
    private int id_address;

    public ListPLACEModel_Need_MN(String description, String name_parent, int id_address) {
        this.description = description;
        this.name_parent = name_parent;
        this.id_address = id_address;
    }

    public ListPLACEModel_Need_MN (JSONObject jsonObj) {

        try {

            this.description = jsonObj.getString("description");
            this.name_parent = jsonObj.getString("name_parent");
            this.id_address = jsonObj.getInt("id_address");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_parent() {
        return name_parent;
    }

    public void setName_parent(String name_parent) {
        this.name_parent = name_parent;
    }
}
