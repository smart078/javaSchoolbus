package com.mart.schoolbusapp.Teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 28/11/2559.
 */

public class Part_Teacher extends Activity {

    private TextView id_teacher;
    private TextView name_teacher;
    private Button BTN_EDT_TEACHER;

    private Data_Teacher teacher;

    private int id;
    private String name;
    private String tel;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_teacher);

//        id_teacher = (TextView)findViewById(R.id.tv1_part_teacher);
//        name_teacher = (TextView)findViewById(R.id.tv2_part_teacher);
//
//        teacher = getIntent().getExtras().getParcelable("TEACHER");
//        id_teacher.setText(String.valueOf(teacher.getId_teacher()));
//        name_teacher.setText(teacher.getName_teacher());

//        id_teacher.setText(String.valueOf(teacher.getId_teacher()));
//        name_teacher.setText(teacher.getName_teacher());

//        id = teacher.getId_teacher();
//        name = teacher.getName_teacher();
//        tel = teacher.getTel_teacher();
//        email = teacher.getEmail_teacher();
//        password = teacher.getPassword_teacher();
//
//        BTN_EDT_TEACHER = (Button)findViewById(R.id.BTN_EDIT_TEACHER);
//        BTN_EDT_TEACHER.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(getApplication(),Update_Teacher.class);
//                final Data_Teacher t = new Data_Teacher(email,id,name,password,tel);
//                intent.putExtra("T",t);
//                startActivity(intent);
//            }
//        });
//
//
//    }
    }
}
