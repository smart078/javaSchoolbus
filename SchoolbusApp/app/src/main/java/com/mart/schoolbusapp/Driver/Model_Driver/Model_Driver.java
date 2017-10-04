package com.mart.schoolbusapp.Driver.Model_Driver;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 1/12/2559.
 */

public class Model_Driver {

    private Map<String,Object> params;

    private Model_Driver()
    {
        this.params = new LinkedHashMap<>();

    }

    public  Model_Driver(String car_registration, String email_driver, int id_driver, String name_driver, String password_driver, String tel_driver, String timestart_evening, String timestart_morning)
    {
        this();

        this.params.put("car_registration", car_registration);
        this.params.put("email_driver", email_driver);
        this.params.put("id_driver", id_driver);
        this.params.put("name_driver",name_driver);
        this.params.put("password_driver",password_driver);
        this.params.put("tel_driver", tel_driver);
        this.params.put("timestart_morning",timestart_morning);
        this.params.put("timestart_evening",timestart_evening);

        Log.i("Model : ", car_registration+" "+email_driver+" "+id_driver+" "+name_driver+" "+password_driver+" "+tel_driver+" "+timestart_morning+" "+timestart_evening);
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
