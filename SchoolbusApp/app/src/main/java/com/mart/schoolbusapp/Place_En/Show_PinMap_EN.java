package com.mart.schoolbusapp.Place_En;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mart.schoolbusapp.NumberPhone_Parent.Number_Phone;
import com.mart.schoolbusapp.Place_Place.Model_New_Place;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mart_ on 16/1/2560.
 */

public class Show_PinMap_EN extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener,
        View.OnClickListener{

    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private double fromLongitude;
    private double fromLatitude;
    private GoogleApiClient googleApiClient;
    private Button buttonSetFromEN;

    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String knownName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_pinmap_en);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_en);
        mapFragment.getMapAsync(this);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(AppIndex.API).build();

        buttonSetFromEN = (Button) findViewById(R.id.buttonSetFrom_en);
        buttonSetFromEN.setOnClickListener(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng latLng = new LatLng(13.7458442, 100.5348068);
        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);

    }

    @Override
    public void onClick(View v) {

        fromLatitude = latitude;
        fromLongitude = longitude;
        Toast.makeText(this, "Lat : "+latitude+" Long : "+longitude, Toast.LENGTH_SHORT).show();
        Log.i("Lat ",""+latitude);
        Log.i("Long ",""+longitude);

        Geocoder geocoder;
        final List<android.location.Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude,longitude,1);
            // Here 1 represent max location result to returned, by documents it recommended 1 to 5

            if (addresses.size() > 0) {
                address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                city = addresses.get(0).getLocality();
                state = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                postalCode = addresses.get(0).getPostalCode();
                knownName = addresses.get(0).getFeatureName();

                Toast.makeText(this, "Address : " + address + " " + city + " " + state + " " + country +
                        " " + postalCode + " " + knownName, Toast.LENGTH_SHORT).show();

                Log.i("ADDRESS : ", "" + address + " " + city + " " + state + " " + country + " " + postalCode + " " + knownName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Show_PinMap.this);
        AlertDialog.Builder builder = new AlertDialog.Builder(Show_PinMap_EN.this);

        builder.setMessage("Address : " + address + " " + city + " " + state + " " + country + " " + postalCode + " " + knownName + " ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {



                ServerConnecter connector = new ServerConnecter();
                connector.connect12("insert_newplace.php", true, false, new Model_New_Place(latitude,longitude,address,city,state,postalCode));

                Toast.makeText(getApplicationContext(),"SUCCESS EN",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(getApplication(), Number_Phone.class);

                intent.putExtra("address_a",address);
                intent.putExtra("city_c",city);
                intent.putExtra("state_s",state);
                intent.putExtra("country_c",country);
                intent.putExtra("postalCode_p",postalCode);

                startActivity(intent);


                //dialog.dismiss();

            }
        });
        builder.show();

    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed( ConnectionResult connectionResult) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));

        latitude = latLng.latitude;
        longitude = latLng.longitude;

    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

        latitude = marker.getPosition().latitude;
        longitude = marker.getPosition().longitude;
        moveMap();

    }

    private void moveMap() {

        LatLng latLng = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions()
                .position(latLng) //setting position
                .draggable(true) //Making the marker draggable
                .title("Current Location")); //Adding a title

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
}
