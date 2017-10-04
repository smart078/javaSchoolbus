package com.mart.schoolbusapp.Tracking;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.mart.schoolbusapp.Driver.Part_Driver;
import com.mart.schoolbusapp.Server.ServerConnecter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Mart_ on 12/2/2560.
 */

public class Myservice extends Service implements getlocationlisterner{

    private Mylocation mylocation;
    private Boolean Saveresult = true;
    private OkHttpClient okHttpClient;

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mylocation = new Mylocation(this);
        mylocation.Startlocation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mylocation.Stoplocation();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        mylocation = new Mylocation(this);
        mylocation.Startlocation();
    }

    @Override
    public void getLatLongLocation(Location location) {

        UpdatelocationToserver(location);

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

                    Toast.makeText(Myservice.this,"UpdateLocationError",Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Saveresult = true;
                    if (response.isSuccessful()){

                        Log.e("isSuccessful","OK Successful");

                    }

                }
            }
            );
        }

    }
}
