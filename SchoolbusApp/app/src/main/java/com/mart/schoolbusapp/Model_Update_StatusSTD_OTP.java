package com.mart.schoolbusapp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 21/2/2560.
 */

public class Model_Update_StatusSTD_OTP {


    private Map<String,Object> params;

    private Model_Update_StatusSTD_OTP()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_Update_StatusSTD_OTP(int id_parent,int id_student)
    {
        this();
        this.params.put("id_parent", id_parent);
        this.params.put("id_student",id_student);
    }

    public byte[] getDataEncode() {
        StringBuilder postData = new StringBuilder();

        byte[] result = null;
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (postData.length() != 0)
                    postData.append('&');

                postData.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                postData.append("=");
                postData.append(URLEncoder.encode("" + entry.getValue(), "UTF-8"));
            }
            result = postData.toString().getBytes("UTF-8");
        }

        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


}
