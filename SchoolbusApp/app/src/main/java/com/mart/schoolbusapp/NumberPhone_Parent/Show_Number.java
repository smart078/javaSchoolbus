package com.mart.schoolbusapp.NumberPhone_Parent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.mart.schoolbusapp.R;

/**
 * Created by Mart_ on 19/1/2560.
 */

public class Show_Number extends Activity {

    private TextView tv_numberPhonee;
    private int number_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_number);

        number_number = getIntent().getIntExtra("random",1);

        tv_numberPhonee = (TextView)findViewById(R.id.TV_NUMBER_PHONE);
        tv_numberPhonee.setText(number_number+"");



    }
}
