package com.mart.schoolbusapp.NumberPhone_Parent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

/**
 * Created by Mart_ on 18/1/2560.
 */

public class Input_Number_Parent extends Activity implements View.OnClickListener {

    private EditText input_nameParent;
    private EditText input_number_phone;

    private Button btn_input_number;

    private int randomPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_number_parent);

        btn_input_number = (Button)findViewById(R.id.btn_submit_numberPhone);
        btn_input_number.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String address_address = getIntent().getStringExtra("address");

        input_nameParent = (EditText) findViewById(R.id.EDT_INPUT_NAME_PARENT);
        final String inputName = input_nameParent.getText().toString();

        input_number_phone = (EditText) findViewById(R.id.EDT_INPUT_NUMBER);
        final String inputNumberPhone = input_number_phone.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(Input_Number_Parent.this);
        builder.setMessage(" Address "+ address_address + "Name Prent : " + inputName + " Phone :  " + inputNumberPhone );
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

//                Intent intent = new Intent(getApplication(),Show_Number.class);
//
//                randomPin = (int)(Math.random()*9000)+1000;
//                Log.i("Random Number " , " " +randomPin );
//
//                intent.putExtra("random",randomPin);
//                startActivity(intent);
//
//                ServerConnecter connecter = new ServerConnecter();
//                connecter.connect13("insert_number_phone.php",true,false, new Model_Number(inputNumberPhone,inputName,randomPin+""));
//
//                Log.i("NumberPhone Name OTP ","" + inputNumberPhone + " " + inputName + " " + randomPin);

//                ServerConnecter connector = new ServerConnecter();
//                connector.connect12("insert_newplace.php", true, false, new Model_New_Place(latitude,longitude,address,city,state,postalCode));

                Toast.makeText(getApplicationContext(),"SUCCESS", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });
        builder.show();

    }
}
