package com.mart.schoolbusapp.Teacher.Model_Teacher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 15/12/2559.
 */

public class Model_ADD_STD {

    private Map<String,Object> params;

    private Model_ADD_STD()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_ADD_STD(String name_parent,String tel_parent,String email_parent,String name_student,String education_student)
    {
        this();
        this.params.put("name_parent", name_parent);
        this.params.put("tel_parent", tel_parent);
        this.params.put("email_parent", email_parent);
        this.params.put("name_student",name_student);
        this.params.put("education_student",education_student);

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
