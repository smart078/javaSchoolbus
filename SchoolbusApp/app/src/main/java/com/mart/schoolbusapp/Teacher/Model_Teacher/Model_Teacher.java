package com.mart.schoolbusapp.Teacher.Model_Teacher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 28/11/2559.
 */

public class Model_Teacher {

    private Map<String,Object> params;

    private Model_Teacher()
    {
        this.params = new LinkedHashMap<>();

    }

    public  Model_Teacher(int id_teacher,String name_teacher, String tel_teacher, String email_teacher, String password_teacher)
    {
        this();
        this.params.put("id_teacher", id_teacher);
        this.params.put("name_teacher", name_teacher);
        this.params.put("tel_teacher", tel_teacher);
        this.params.put("email_teacher",email_teacher);
        this.params.put("password_teacher",password_teacher);
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
