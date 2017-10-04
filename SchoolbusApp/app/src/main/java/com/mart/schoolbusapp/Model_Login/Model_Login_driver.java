package com.mart.schoolbusapp.Model_Login;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 25/11/2559.
 */

public class Model_Login_driver {

    private Map<String,Object> params;

    private Model_Login_driver()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_Login_driver(String email_driver)
    {
        this();
        this.params.put("email_driver", email_driver);
//        this.params.put("password_driver", password_driver);
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
