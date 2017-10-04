package com.mart.schoolbusapp.Driver;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mart.schoolbusapp.Driver.Model_Driver.Data_Driver;
import com.mart.schoolbusapp.Manage_Student.ListLEVEL_Fragment;
import com.mart.schoolbusapp.Parent.P_DataDriver;
import com.mart.schoolbusapp.Place_En.ListPLACE_Fragment_EN;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;
import com.mart.schoolbusapp.Teacher.Data_Teacher;
import com.mart.schoolbusapp.Tracking.Mylocation;
import com.mart.schoolbusapp.Tracking.Myservice;
import com.mart.schoolbusapp.Tracking.getlocationlisterner;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Mart_ on 30/11/2559.
 */

public class Part_Driver extends FragmentActivity implements ListLEVEL_Fragment.OnFragmentListener,getlocationlisterner {

    private Button BTN_EDIT;
    private TextView id_driver;
    private TextView name_driver;

    private Data_Driver driver;

    private int id;
    private String name;
    private String tel;
    private String email;
    private String password;
    private String morning;
    private String evening;
    private String car;

    private Mylocation mylocation;
    public static boolean Saveresult = true;
    public OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_driver);

        ListLEVEL_Fragment listLEVEL_fragment = new ListLEVEL_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_driver, listLEVEL_fragment, ListLEVEL_Fragment.class.getSimpleName());
        fragmentTransaction.commit();

        id_driver = (TextView)findViewById(R.id.tv1_part_driver);
        name_driver = (TextView)findViewById(R.id.tv2_part_driver);

        driver = getIntent().getExtras().getParcelable("DRIVER");
        id_driver.setText(String.valueOf(driver.getId_driver()));
        name_driver.setText(driver.getName_driver());

        id = driver.getId_driver();
        name = driver.getName_driver();
        tel = driver.getTel_driver();
        email = driver.getEmail_driver();
        password = driver.getPassword_driver();
        morning = driver.getTimestart_morning();
        evening = driver.getTimestart_evening();
        car = driver.getCar_registration();

        BTN_EDIT = (Button)findViewById(R.id.BTN_EDIT_DRIVER);
        BTN_EDIT.setVisibility(View.GONE);
        BTN_EDIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(),Update_Driver.class);
                final Data_Driver d = new Data_Driver(car,email,id,name,password,tel,evening,morning);
                intent.putExtra("D",d);
                startActivity(intent);

            }
        });

        mylocation = new Mylocation(Part_Driver.this);
        mylocation.Startlocation();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mylocation.Startlocation();
        stopService(new Intent(Part_Driver.this, Myservice.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        mylocation.Stoplocation();
        Intent intent = new Intent(Part_Driver.this, Myservice.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mylocation.Startlocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mylocation.Stoplocation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onFragmentInteractionPLACE(Uri uri) {

    }

    @Override
    public void getLatLongLocation(Location location) {


        UpdatelocationToserver(location);
        Log.e("Locationff",""+location.getLatitude());

    }

    private void UpdatelocationToserver(Location location){

        if (Saveresult){

            Saveresult = false;

            okHttpClient = new OkHttpClient();
            RequestBody form = new FormBody.Builder()
                    .add("function", "updatelocation")
                    .add("latitude", String.valueOf(location.getLatitude()))
                    .add("longitude", String.valueOf(location.getLongitude()))
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(ServerConnecter.seturl+"Schoolbus.php").post(form).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                    Saveresult = true;

                    Part_Driver.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Part_Driver.this, "UpdatelocationToserver Failure", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    Saveresult = true;

                    if (response.isSuccessful()) {
                        Log.e("isSuccessful", "OK Successful");
                    }

                }

            });


        }

    }
}
