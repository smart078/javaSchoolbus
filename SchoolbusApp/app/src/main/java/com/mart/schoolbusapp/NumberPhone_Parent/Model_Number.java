package com.mart.schoolbusapp.NumberPhone_Parent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 20/1/2560.
 */

public class Model_Number {

    private Map<String,Object> params;

    private Model_Number()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_Number(String phone_number, String phone_name ,String otp_number,int id_parent,int id_statusNeed,int id_address)
    {
        this();
        this.params.put("phone_number", phone_number);
        this.params.put("phone_name", phone_name);
        this.params.put("otp_number", otp_number);
        this.params.put("id_parent", id_parent);
        this.params.put("id_statusNeed", id_statusNeed);
        this.params.put("id_address", id_address);
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
