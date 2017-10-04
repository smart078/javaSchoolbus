package com.mart.schoolbusapp.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mart.schoolbusapp.Model_Login.Model_Login_parent;
import com.mart.schoolbusapp.Parent.Data_parent;
import com.mart.schoolbusapp.Parent.Part_Parent;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 24/11/2559.
 */

public class Login_Parent extends Activity implements View.OnClickListener {

    private Button btn_log_parent;
    private Data_parent parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_parent);

        btn_log_parent = (Button)findViewById(R.id.btnlog_parent);
        btn_log_parent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText edtuser_parent = (EditText)findViewById(R.id.EDT_USER_Parent);
        String eamil = edtuser_parent.getText().toString();

//        EditText edtpassword_parent = (EditText)findViewById(R.id.EDT_PASSWORD_Parent);
//        String password = edtpassword_parent.getText().toString();

        ServerConnecter connecter = new ServerConnecter();
        String re = connecter.connect2("select_login_parent.php",true,true,new Model_Login_parent(eamil));
        JSONArray arr = connecter.getResponseArray(re);

        for(int i=0;i<arr.length();i++) {

            try {
                parent = new  Data_parent(arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        if (arr != null && arr.length() > 0 ){
            Intent intent = new Intent(this, Part_Parent.class);
            intent.putExtra("PARENT", parent);
            startActivity(intent);



        }

    }
}
