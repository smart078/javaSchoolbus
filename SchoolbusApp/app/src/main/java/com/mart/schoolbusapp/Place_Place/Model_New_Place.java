package com.mart.schoolbusapp.Place_Place;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mart_ on 6/1/2560.
 */

public class Model_New_Place {

    private Map<String,Object> params;

    private Model_New_Place()
    {
        this.params = new LinkedHashMap<>();
    }

    public  Model_New_Place(Double latitude,Double longitude, String description, String district, String province, String number_post)
    {
        this();
        this.params.put("description", description);
//        this.params.put("number_village", number_village);
//        this.params.put("soi", soi);
//        this.params.put("road", road);
//        this.params.put("subdistrict", subdistrict);
        this.params.put("district", district);
        this.params.put("province", province);
        this.params.put("number_post", number_post);

        this.params.put("latitude", latitude+"");
        this.params.put("longitude", longitude+"");

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
