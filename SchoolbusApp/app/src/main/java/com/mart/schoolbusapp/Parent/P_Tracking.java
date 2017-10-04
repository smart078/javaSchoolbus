package com.mart.schoolbusapp.Parent;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mart.schoolbusapp.R;
import com.mart.schoolbusapp.Server.ServerConnecter;
import com.mart.schoolbusapp.Tracking.LocationSchoolbus;
import com.mart.schoolbusapp.Tracking.Mylocation;
import com.mart.schoolbusapp.Tracking.getlocationlisterner;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationParams;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesWithFallbackProvider;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Mart_ on 9/12/2559.
 */

public class P_Tracking extends Fragment implements OnLocationUpdatedListener {

    public Mylocation mylocation;

    private Boolean requestresult = true;
    private OkHttpClient okHttpClient;
    public GoogleMap mMap;
    public Marker busMarker,myMarker;

    MapView mMapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.p_tracking, container, false);

        mMapView = (MapView)view.findViewById(R.id.frame_map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });


//        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.frame_map);
//        mapFragment.getMapAsync(this);

        SmartLocation.with(getActivity().getApplicationContext())
                .location(new LocationGooglePlayServicesWithFallbackProvider(getActivity().getApplicationContext()))
                .continuous()
                .config(LocationParams.NAVIGATION)
                .start(this);

        return view;

    }


//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//        mMap = googleMap;
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        //mylocation.Stoplocation();

    }

    @Override
    public void onLocationUpdated(Location location) {

        if (myMarker != null)
            myMarker.remove();
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_person_pin_circle_black_24dp);
        myMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude()))
                .title("School Bus")
                .icon(icon));

        getLocationSchoolbus();
        Log.e("Locationff",""+location.getLatitude());
    }

    private void getLocationSchoolbus(){

        if (requestresult) {

            requestresult = false;

            okHttpClient = new OkHttpClient();
            RequestBody form = new FormBody.Builder()
                    .add("function", "getLocationschoolbus")
                    .build();
            Request.Builder builder = new Request.Builder();
            final Request request = builder.url(ServerConnecter.seturl+"Schoolbus.php").post(form).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    requestresult = true;

                    Log.e("ERROR CALLBACK",""+e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    requestresult = true;
                    Gson gson = new Gson();
                    if (response.isSuccessful()) {
                        try {

                            Log.e("isSuccessfulsss", "OK Successful");
                            String resulsts = response.body().string();
                            Log.e("rs", resulsts);
                            Type listType = new TypeToken<List<LocationSchoolbus>>() {
                            }.getType();
                            List<LocationSchoolbus> locationSchoolbusList = gson.fromJson(resulsts, listType);
                            if (locationSchoolbusList.get(0).getLatitude() != 0 && locationSchoolbusList.get(0).getLatitude() != 0) {
                                UpdateMarkerSchoolbus(locationSchoolbusList.get(0).getLatitude(), locationSchoolbusList.get(0).getLongtitude());
                            }


                        } catch (Exception e) {
                            Log.e("erroimgonResponse", e.getMessage());
                        }
                    }


                }
            });

        }

    }

    private void UpdateMarkerSchoolbus(final double Latitude, final double Longitude) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (busMarker != null)
                    busMarker.remove();
                Log.e("rs", String.valueOf(Latitude));
                BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_directions_bus_black_24dp);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Latitude, Longitude), 16));
                busMarker = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(Latitude, Longitude))
                        .title("School Bus")
                        .icon(icon));
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
