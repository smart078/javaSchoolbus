package com.mart.schoolbusapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mart_ on 21/2/2560.
 */

public class Data_Count_Number {

    private int num;

    public Data_Count_Number(int num) {
        this.num = num;
    }

    public Data_Count_Number(JSONObject jsonObj) {

        try {
            this.num = jsonObj.getInt("num");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
