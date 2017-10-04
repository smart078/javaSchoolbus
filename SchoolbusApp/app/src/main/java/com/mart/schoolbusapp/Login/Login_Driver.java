package com.mart.schoolbusapp.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mart.schoolbusapp.Driver.Model_Driver.Data_Driver;
import com.mart.schoolbusapp.Driver.Part_Driver;
import com.mart.schoolbusapp.MainActivity;
import com.mart.schoolbusapp.Main_PTD;
import com.mart.schoolbusapp.Model_Login.Model_Login_driver;
import com.mart.schoolbusapp.Parent.Data_parent;
import com.mart.schoolbusapp.Parent.Part_Parent;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 24/11/2559.
 */

public class Login_Driver extends Activity implements View.OnClickListener {

    private Button btn_log_driver;
    private Button btn_back_menu_drive;
    private Data_Driver driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_driver);

        btn_log_driver = (Button)findViewById(R.id.btnlog_driver);
        btn_log_driver.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        EditText edtuser_driver = (EditText)findViewById(R.id.EDT_USER_Driver);
        String email_Driver = edtuser_driver.getText().toString();

//        EditText edtpassword_driver = (EditText)findViewById(R.id.EDT_PASSWORD_Driver);
//        String password_Driver = edtpassword_driver.getText().toString();

        ServerConnecter connecter = new ServerConnecter();
        String re = connecter.connect3("select_login_driver.php",true,true,new Model_Login_driver(email_Driver));
        JSONArray arr = connecter.getResponseArray(re);
        Log.i("Login JSON", ""+arr);
        Toast.makeText(this,"RESULT : "+arr,Toast.LENGTH_SHORT).show();

        for(int i=0;i<arr.length();i++) {

            try {
                driver = new Data_Driver(arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if (arr != null && arr.length() > 0 ){
            Intent intent = new Intent(this, Part_Driver.class);
            intent.putExtra("DRIVER", driver);
            startActivity(intent);

        }

    }

}
