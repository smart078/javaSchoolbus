package com.mart.schoolbusapp.Parent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mart.schoolbusapp.Login.Login_Parent;
import com.mart.schoolbusapp.Parent.Model_Parent.Model_Parent;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

/**
 * Created by Mart_ on 27/11/2559.
 */

public class Update_Parent_P extends Activity {

    private Button btn_upadate;
    private Data_parent parent;

    private EditText edt_id_parent;
    private EditText edt_name_parent;
    private EditText edt_tel_parent;
    private EditText edt_email_parent;
    private EditText edt_password_parent;

    private TextView tv_name_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_parent);

        parent = getIntent().getExtras().getParcelable("P");
        //Log.i("P"," : "+parent);

        tv_name_parent = (TextView)findViewById(R.id.tv_name_regis);
        tv_name_parent.setText(parent.getName_parent());

        edt_id_parent = (EditText)findViewById(R.id.EDT_parent_id);
        final int id_parent = parent.getId_parent();
        edt_id_parent.setText(id_parent+"");
        Log.i("ID"," : "+id_parent);

        edt_name_parent = (EditText)findViewById(R.id.EDT_parent_name);
        final String name_parent = parent.getName_parent();
        edt_name_parent.setText(name_parent);
        Log.i("Name"," : "+name_parent);

        edt_tel_parent = (EditText)findViewById(R.id.EDT_parent_tel);
        final String tel_parent = parent.getTel_parent();
        edt_tel_parent.setText(tel_parent);
        Log.i("Tel"," : "+tel_parent);

        edt_email_parent = (EditText)findViewById(R.id.EDT_parent_email);
        final String email_parent = parent.getEmail_parent();
        edt_email_parent.setText(email_parent);
        Log.i("email"," : "+email_parent);

        edt_password_parent = (EditText)findViewById(R.id.EDT_parent_password);
//        final String password_parent = parent.getPassword_parent();
//        edt_password_parent.setText(password_parent);

        //Log.i("Pass"," : "+password_parent);

        btn_upadate = (Button)findViewById(R.id.btn_parent_update);
        btn_upadate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int id_p = Integer.parseInt(edt_id_parent.getText().toString());
                String name_p = edt_name_parent.getText().toString();
                String tel_p = edt_tel_parent.getText().toString();
                String email_p = edt_email_parent.getText().toString();
                String password_p = edt_password_parent.getText().toString();

                Intent aintent = new Intent(getApplication(), Login_Parent.class);

                aintent.putExtra("id_parent", id_p);
                aintent.putExtra("name_parent", name_p);
                aintent.putExtra("tel_parent", tel_p);
                aintent.putExtra("email_parent", email_p);
                aintent.putExtra("password_parent",password_p);
                //Log.i("idParent"," : "+id_parent);
                Log.i("TEL ",""+tel_p);

                ServerConnecter connector = new ServerConnecter();
                connector.connect5("update_parent.php",true,false,new Model_Parent(id_p,name_p,tel_p,email_p,password_p));

                startActivity(aintent);

            }
        });



    }
}
