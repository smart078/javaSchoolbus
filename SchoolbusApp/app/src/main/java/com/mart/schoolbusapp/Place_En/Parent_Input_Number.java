package com.mart.schoolbusapp.Place_En;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mart.schoolbusapp.NumberPhone_Parent.Model_Number;
import com.mart.schoolbusapp.NumberPhone_Parent.Show_Number;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

/**
 * Created by Mart_ on 17/2/2560.
 */

public class Parent_Input_Number extends Activity implements View.OnClickListener {

    private EditText number_phone;
    private EditText name_parent_phone;
    private Button btn_submit_number;

    private int randomPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_input_number);

        btn_submit_number = (Button)findViewById(R.id.btn_parent_submit_numberPhone);
        btn_submit_number.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        number_phone = (EditText)findViewById(R.id.EDT_PARENT_INPUT_NUMBER);
        final String input_NumberPhone = number_phone.getText().toString();

        name_parent_phone = (EditText)findViewById(R.id.EDT_PARENT_INPUT_NAME_PARENT);
        final String input_NameParent = name_parent_phone.getText().toString();

        int p = getIntent().getIntExtra("id_parent",1);
        int a = getIntent().getIntExtra("id_address",2);
        int s = getIntent().getIntExtra("id_statusNeed",3);

        Intent intent = new Intent(getApplication(),Show_Number.class);

        randomPin = (int)(Math.random()*9000)+1000;
        Log.i("Random Number " , " " +randomPin );

        intent.putExtra("random",randomPin);

        startActivity(intent);

        ServerConnecter connecter = new ServerConnecter();
        connecter.connect13("insert_number_phone.php",true,false, new Model_Number(input_NumberPhone,input_NameParent,randomPin+"",p,s,a));

        Log.i("NumberPhone Name OTP ","" + input_NumberPhone + " " + input_NameParent + " " + randomPin);
        Log.i("ID P S A "," ID PARENT : " + p + " ID STATUSNEED : " + s + " ID ADDRESS : "  + a);

    }

}
