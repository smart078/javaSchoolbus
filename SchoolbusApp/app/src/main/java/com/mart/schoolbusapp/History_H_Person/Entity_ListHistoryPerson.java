package com.mart.schoolbusapp.History_H_Person;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 6/3/2560.
 */

public class Entity_ListHistoryPerson {

    private Map<String,Object> params;

    private Entity_ListHistoryPerson()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Entity_ListHistoryPerson(int id_student)
    {
        this();
        this.params.put("id_student", id_student);

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
