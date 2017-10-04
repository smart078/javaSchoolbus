package com.mart.schoolbusapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mart.schoolbusapp.History_H.History;
import com.mart.schoolbusapp.Teacher.Add_STD;
import com.mart.schoolbusapp.Teacher.Data_Teacher;
import com.mart.schoolbusapp.Teacher.Update_Teacher;

/**
 * Created by Mart_ on 23/12/2559.
 */

public class Menu_Teacher extends Activity {

    //private TextView id_teacher;
    private TextView name_teacher;

    private Data_Teacher teacher;

    private int id;
    private String name;
    private String tel;
    private String email;
    private String password;

    private Button button_list_student;
    private Button button_add_student;
    private Button button_edit_profile;
    private Button button_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_teacher);


        name_teacher = (TextView)findViewById(R.id.tv_tv_nameTeacher);
        //id_teacher = (TextView)findViewById(R.id.tv_tv_idTeacher);

        teacher = getIntent().getExtras().getParcelable("TEACHER");
        //id_teacher.setText(String.valueOf(teacher.getId_teacher()));
        name_teacher.setText(teacher.getName_teacher());

       // id = teacher.getId_teacher();
        name = teacher.getName_teacher();
        tel = teacher.getTel_teacher();
        email = teacher.getEmail_teacher();
        password = teacher.getPassword_teacher();


        button_list_student = (Button)findViewById(R.id.btn_list_student);
        button_list_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplication(),ListSTD_Activity.class);
                startActivity(intent1);

            }
        });


        button_add_student = (Button)findViewById(R.id.btn_add_student);
        button_add_student.setVisibility(View.GONE);
        button_add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(getApplication(),Add_STD.class);
                final Data_Teacher t = new Data_Teacher(email,id,name,password,tel);
                intent2.putExtra("T",t);
                startActivity(intent2);

            }
        });

        button_edit_profile = (Button)findViewById(R.id.btn_edit_profile);
        button_edit_profile.setVisibility(View.GONE);
        button_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = new Intent(getApplication(), Update_Teacher.class);
                final Data_Teacher t = new Data_Teacher(email,id,name,password,tel);
                intent3.putExtra("T",t);
                startActivity(intent3);

            }
        });

        button_history = (Button)findViewById(R.id.btn_history);
        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4 = new Intent(getApplication(), History.class);
                startActivity(intent4);

            }
        });

    }
}
