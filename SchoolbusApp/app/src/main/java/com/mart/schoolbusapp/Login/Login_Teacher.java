package com.mart.schoolbusapp.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mart.schoolbusapp.ListSTD_Activity;
import com.mart.schoolbusapp.Menu_Teacher;
import com.mart.schoolbusapp.Model_Login.Model_Login_teacher;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;
import com.mart.schoolbusapp.Teacher.Data_Teacher;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Mart_ on 24/11/2559.
 */

public class Login_Teacher extends Activity implements View.OnClickListener {

    private Button btn_log_teacher;
    private Data_Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_teacher);

        btn_log_teacher = (Button)findViewById(R.id.btnlog_teacher);
        btn_log_teacher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText edtuser_teacher = (EditText)findViewById(R.id.EDT_USER_Teacher);
        String email_Teacher = edtuser_teacher.getText().toString();

//        EditText edtpassword_teacher = (EditText)findViewById(R.id.EDT_PASSWORD_Teacher);
//        String password_Teacher = edtpassword_teacher.getText().toString();

        ServerConnecter connecter = new ServerConnecter();
        String re = connecter.connect4("select_login_teacher.php",true,true,new Model_Login_teacher(email_Teacher));
        JSONArray arr = connecter.getResponseArray(re);

        Log.i("Login JSON", ""+arr);
        Toast.makeText(this,"RESULT : "+arr,Toast.LENGTH_SHORT).show();

        for(int i=0;i<arr.length();i++) {

            try {
                teacher = new Data_Teacher(arr.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        if (arr != null && arr.length() > 0 ){
            Intent intent = new Intent(this,Menu_Teacher.class);
            intent.putExtra("TEACHER", teacher);
            startActivity(intent);
        }

    }
}
