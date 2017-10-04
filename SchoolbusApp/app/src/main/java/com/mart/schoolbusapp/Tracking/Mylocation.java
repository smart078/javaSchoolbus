package com.mart.schoolbusapp.Tracking;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.provider.Settings;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;

/**
 * Created by Mart_ on 11/2/2560.
 */

public class Mylocation implements OnLocationUpdatedListener {

    private Context context;
    private getlocationlisterner getlocationlist;

    public Mylocation(Context context) {
        this.context = context;
        this.getlocationlist = (getlocationlisterner) this.context;
    }


    @Override
    public void onLocationUpdated(Location location) {

        getlocationlist.getLatLongLocation(location);

    }

    public void Startlocation(){

        if(SmartLocation.with(context).location().state().locationServicesEnabled()){

            LocationParams locationParams = new LocationParams.Builder()
                    .setAccuracy(LocationAccuracy.HIGH)
                    .setDistance(20)
                    //.setInterval(1000)
                    .build();

            SmartLocation.with(context)
                    .location(new LocationGooglePlayServicesWithFallbackProvider(context))
//                    .continuous()
                    .config(LocationParams.NAVIGATION)
                    .start(this);

        }else{
            locationServiceUnavailable();
        }
    }

    public void locationServiceUnavailable(){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("เเจ้งเตือน!");
        builder.setMessage("บหริการหาตำเเหน่งมือถือของคุณถูกปิดอยู่!");
        builder.setPositiveButton("เปิด", new AlertDialog.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                dialog.dismiss();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }

        });
        builder.setNegativeButton("ไม่ต้องการ", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    public void Stoplocation(){

        SmartLocation.with(context).location().stop();
    }

}
