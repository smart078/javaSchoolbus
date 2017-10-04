package com.mart.schoolbusapp.Model_Login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 24/11/2559.
 */

public class Model_Login_parent {

    private Map<String,Object> params;

    private Model_Login_parent()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_Login_parent(String email_parent)
    {
        this();
        this.params.put("email_parent", email_parent);
//        this.params.put("password_parent", password_parent);
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
