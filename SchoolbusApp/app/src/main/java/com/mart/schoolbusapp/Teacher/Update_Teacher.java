package com.mart.schoolbusapp.Teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mart.schoolbusapp.Login.Login_Teacher;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;
import com.mart.schoolbusapp.Teacher.Model_Teacher.Model_Teacher;

/**
 * Created by Mart_ on 28/11/2559.
 */

public class Update_Teacher extends Activity {

    private Button btn_update;
    private Data_Teacher teacher;

    private TextView tv_name_teacher;

    private EditText edt_id_teacher;
    private EditText edt_name_teacher;
    private EditText edt_tel_teacher;
    private EditText edt_email_teacher;
    private EditText edt_password_teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_teacher);

        teacher = getIntent().getExtras().getParcelable("T");

        tv_name_teacher = (TextView)findViewById(R.id.tv1_teacher_xxx);
        tv_name_teacher.setText(teacher.getName_teacher());

        edt_id_teacher = (EditText)findViewById(R.id.EDT_teacher_id);
        final int id_teacher = teacher.getId_teacher();
        edt_id_teacher.setText(id_teacher+"");

        edt_name_teacher = (EditText)findViewById(R.id.EDT_teacher_name);
        final String name_teacher = teacher.getName_teacher();
        edt_name_teacher.setText(name_teacher);

        edt_tel_teacher = (EditText)findViewById(R.id.EDT_teacher_tel);
        final String tel_teacher = teacher.getTel_teacher();
        edt_tel_teacher.setText(tel_teacher);

        edt_email_teacher = (EditText)findViewById(R.id.EDT_teacher_email);
        final String email_teacher = teacher.getEmail_teacher();
        edt_email_teacher.setText(email_teacher);

        edt_password_teacher = (EditText)findViewById(R.id.EDT_teacher_password);
//        final String password_teacher = teacher.getPassword_teacher();
//        edt_password_teacher.setText(password_teacher);

        btn_update = (Button)findViewById(R.id.btn_teacher_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id_t = Integer.parseInt(edt_id_teacher.getText().toString());
                String name_t = edt_name_teacher.getText().toString();
                String tel_t = edt_tel_teacher.getText().toString();
                String email_t = edt_email_teacher.getText().toString();
                String password_t = edt_password_teacher.getText().toString();

                Intent intentt = new Intent(getApplication(), Login_Teacher.class);

                intentt.putExtra("id_teacher",id_t);
                intentt.putExtra("name_teacher",name_t);
                intentt.putExtra("tel_teacher",tel_t);
                intentt.putExtra("email_teacher",email_t);
                intentt.putExtra("password_teacher",password_t);
                Log.i("TEL ",""+id_t);
                Log.i("TEL ",""+name_t);
                Log.i("TEL ",""+tel_t);
                Log.i("TEL ",""+email_t);
                Log.i("TEL ",""+password_t);

                ServerConnecter connecter = new ServerConnecter();
                connecter.connect7("update_teacher.php",true,false,new Model_Teacher(id_t,name_t,tel_t,email_t,password_t));
                startActivity(intentt);

            }
        });


    }
}
