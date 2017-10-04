package com.mart.schoolbusapp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 6/1/2560.
 */

public class Model_StatusNeed {

    private Map<String,Object> params;

    private Model_StatusNeed()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_StatusNeed(int id_statusNeed,int id_parent, int id_address,int id_number_phone)
    {
        this();
        this.params.put("id_statusNeed", id_statusNeed);
        this.params.put("id_parent", id_parent);
        this.params.put("id_address", id_address);
        this.params.put("id_number_phone", id_number_phone);

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
