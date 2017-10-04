package com.mart.schoolbusapp.Server;

import android.os.StrictMode;
import android.util.Log;

import com.mart.schoolbusapp.Driver.Model_Driver.Model_Driver;
import com.mart.schoolbusapp.History_H_Person.Entity_ListHistoryPerson;
import com.mart.schoolbusapp.ListSTD.EntityModelListSTD;
import com.mart.schoolbusapp.Model_IdParent_Number;
import com.mart.schoolbusapp.Model_Number_OTP;
import com.mart.schoolbusapp.Model_Update_StatusSTD_OTP;
import com.mart.schoolbusapp.NumberPhone_Parent.ListNumberModel;
import com.mart.schoolbusapp.NumberPhone_Parent.Model_Number;
import com.mart.schoolbusapp.Place_Place.Model_Need_MN;
import com.mart.schoolbusapp.Place_Place.Model_New_Place;
import com.mart.schoolbusapp.Model_StatusNeed;
import com.mart.schoolbusapp.Place_Place.Model_Parent_Need_MN;
import com.mart.schoolbusapp.Teacher.Model_Teacher.Model_ADD_STD;
import com.mart.schoolbusapp.Parent.Model_Parent.Model_Infor_P;
import com.mart.schoolbusapp.Model_Login.Model_Login_driver;
import com.mart.schoolbusapp.Model_Login.Model_Login_parent;
import com.mart.schoolbusapp.Model_Login.Model_Login_teacher;
import com.mart.schoolbusapp.Parent.Model_Parent.Model_Parent;
import com.mart.schoolbusapp.Parent.Model_Parent.Model_Parent_Id;
import com.mart.schoolbusapp.Teacher.Model_Teacher.Model_Teacher;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mart_ on 19/11/2559.
 */

public class ServerConnecter {

    public final static String http   = "http://";
    public final static String ip     = "192.168.1.6";
    public final static String dir    = "T-sis078/";
    public final static String seturl = http+ip+"/"+dir;

    public  ServerConnecter() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public String connect(String page,boolean post,boolean response,EntityModelListSTD model) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect2(String page,boolean post,boolean response,Model_Login_parent model_login_parent) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_login_parent.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect3(String page,boolean post,boolean response,Model_Login_driver model_login_driver) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_login_driver.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect4(String page,boolean post,boolean response,Model_Login_teacher model_login_teacher) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_login_teacher.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect5(String page,boolean post,boolean response,Model_Parent model_parent) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_parent.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect6(String page,boolean post,boolean response,Model_Parent_Id model_parent_id) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = http+ip+dir+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_parent_id.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);
                }
            }
            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect7(String page,boolean post,boolean response,Model_Teacher model_teacher) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_teacher.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect8(String page,boolean post,boolean response,Model_Driver model_driver) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_driver.getDataEncode());
                //Log.i("outstream : ", String.valueOf(model_driver.getDataEncode()));
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect9(String page, boolean post, boolean response, Model_Infor_P model_infor_p) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_infor_p.getDataEncode());
                //Log.i("outstream : ", String.valueOf(model_driver.getDataEncode()));
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect10(String page, boolean post, boolean response, Model_ADD_STD model_add_std) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_add_std.getDataEncode());
                //Log.i("outstream : ", String.valueOf(model_driver.getDataEncode()));
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect11(String page, boolean post, boolean response, Model_StatusNeed model_statusNeed) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_statusNeed.getDataEncode());
                //Log.i("outstream : ", String.valueOf(model_driver.getDataEncode()));
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect12(String page, boolean post, boolean response, Model_New_Place model_new_place) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_new_place.getDataEncode());
                //Log.i("outstream : ", String.valueOf(model_driver.getDataEncode()));
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect13(String page, boolean post, boolean response, Model_Number model_number) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_number.getDataEncode());
                //Log.i("outstream : ", String.valueOf(model_driver.getDataEncode()));
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect14(String page,boolean post,boolean response,Model_Number_OTP model_number_otp) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_number_otp.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect15(String page,boolean post,boolean response,Model_Update_StatusSTD_OTP model_update_statusSTD_otp) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_update_statusSTD_otp.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect16(String page,boolean post,boolean response,Model_IdParent_Number model_idParent_number) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_idParent_number.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect17(String page,boolean post,boolean response,Entity_ListHistoryPerson entity_listHistoryPerson) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(entity_listHistoryPerson.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect18(String page,boolean post,boolean response,Model_Need_MN model_need_mn) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_need_mn.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }

    public String connect19(String page,boolean post,boolean response,Model_Parent_Need_MN model_parent_need_mn) {

        StringBuilder result = new StringBuilder();
        Log.i("HTTP_CONNECT", "Start Connect");

        String url = seturl+page;
        int responseCode = 0;
        HttpURLConnection connection = null;

        try {
            URL urlcon = new URL(url);
            Log.i("URL", url);
            connection = (HttpURLConnection) urlcon.openConnection();
            connection.setDoInput(true);

            if(post == true){

                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("charset", "utf-8");

                DataOutputStream outstream = new DataOutputStream(connection.getOutputStream());
                outstream.write(model_parent_need_mn.getDataEncode());
            }

            if(response == true) {

                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));

                while ((line = br.readLine())!= null ) {

                    result.append(line);

                }
            }

            responseCode = connection.getResponseCode();
            Log.i("HTTP_CONNECT","RESPONS CODE: "+responseCode);

        } catch (MalformedURLException e) {
            Log.e("HTTP_CONNECT","URL ERROR.");
            e.printStackTrace();

        } catch (IOException e) {
            Log.e("HTTP_CONNECT","HTTP CONNECT IO ERROR.");
            e.printStackTrace();
        }

        connection.disconnect();

        return result.toString();

    }




    public JSONArray getResponseArray(String stresponse) {
        JSONArray resultarray = null;

        try {
            resultarray = new JSONArray(stresponse);

            Log.i("JSON_CONVERT", "Result: \n" + stresponse);

        } catch (JSONException e) {
            Log.e("JSON_CONVERT","Error in JSONARRAY: "+e.toString());

            e.printStackTrace();
        }

        return resultarray;

    }
}
