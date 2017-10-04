package com.mart.schoolbusapp.Teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mart.schoolbusapp.Login.Login_Teacher;
import com.mart.schoolbusapp.Menu_Teacher;
import com.mart.schoolbusapp.Teacher.Model_Teacher.Model_ADD_STD;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

/**
 * Created by Mart_ on 15/12/2559.
 */

public class Add_STD extends Activity implements View.OnClickListener{

    private EditText edt_name_parent;
    private EditText edt_tel_parent;
    private EditText edt_email_parent;
    private EditText edt_name_student;
    private EditText edt_education_student;

    private CheckBox checkBox_morning;
    private CheckBox checkBox_evening;

    private Button btn_add;

    private Data_Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_std);

        teacher = getIntent().getExtras().getParcelable("T");

        checkBox_morning = (CheckBox)findViewById(R.id.CB_MN);
        checkBox_evening = (CheckBox)findViewById(R.id.CB_EN);

        btn_add = (Button)findViewById(R.id.btn_teacher_input);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        edt_name_parent = (EditText)findViewById(R.id.EDT_add_NameParent);
        edt_tel_parent = (EditText)findViewById(R.id.EDT_add_TelParent);
        edt_email_parent = (EditText)findViewById(R.id.EDT_add_EmailParent);

        edt_name_student = (EditText)findViewById(R.id.EDT_add_namestd);
        edt_education_student = (EditText)findViewById(R.id.EDT_add_EDU);

        String name_p = edt_name_parent.getText().toString();
        //String tel_p_ = edt_tel_parent.getText().toString();
        String tel_parent = edt_tel_parent.getText().toString();
        String email_p = edt_email_parent.getText().toString();
        String name_s = edt_name_student.getText().toString();
        String education_s = edt_education_student.getText().toString();

//        intent.putExtra("name_parent",name_p);
//        //intent.putExtra("tel_parent",tel_p);
//        intent.putExtra("tel_parent",tel_parent);
//        intent.putExtra("email_parent",email_p);
//        intent.putExtra("name_student",name_s);
//        intent.putExtra("education_student",education_s);

        if (checkBox_morning.isChecked() && checkBox_evening.isChecked()){

            int periodMN = 1;
            int periodEN = 2;
            Log.i("MN & EN Checked ",""+periodMN+periodEN);
            Toast.makeText(this,"morning & evening is checked " +periodMN+periodEN,Toast.LENGTH_SHORT).show();

            ServerConnecter connecter = new ServerConnecter();
            connecter.connect10("add_Student.php",true,false,new Model_ADD_STD(name_p,tel_parent,email_p,name_s,education_s));

            Intent intent= new Intent(getApplication(),Menu_Teacher.class);
            intent.putExtra("TEACHER",teacher);
            startActivity(intent);
        }

        else if (checkBox_morning.isChecked()){

            int periodMN = 1;
            Log.i("MN Checked ",""+periodMN);
            Toast.makeText(this,"morning is checked " +periodMN,Toast.LENGTH_SHORT).show();

            ServerConnecter connecter = new ServerConnecter();
            connecter.connect10("add_StudentMN.php",true,false,new Model_ADD_STD(name_p,tel_parent,email_p,name_s,education_s));

            Intent intent= new Intent(getApplication(),Menu_Teacher.class);
            intent.putExtra("TEACHER",teacher);
            startActivity(intent);
        }

        else if (checkBox_evening.isChecked()){

            int periodEN = 2;
            Log.i("EN Checked ",""+periodEN);
            Toast.makeText(this,"evening is checked "+periodEN,Toast.LENGTH_SHORT).show();

            ServerConnecter connecter = new ServerConnecter();
            connecter.connect10("add_StudentEN.php",true,false,new Model_ADD_STD(name_p,tel_parent,email_p,name_s,education_s));

            Intent intent= new Intent(getApplication(),Menu_Teacher.class);
            intent.putExtra("TEACHER",teacher);
            startActivity(intent);
        }

    }
}
