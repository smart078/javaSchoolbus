package com.mart.schoolbusapp.ListSTD;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 19/11/2559.
 */

public class EntityModelListSTD {

    private Map<String,Object> params;

    private EntityModelListSTD()
    {
        this.params = new LinkedHashMap<>();
    }

    public  EntityModelListSTD(int id_student,int status)
    {
        this();
        this.params.put("id_student", id_student);
        this.params.put("status", status);
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
