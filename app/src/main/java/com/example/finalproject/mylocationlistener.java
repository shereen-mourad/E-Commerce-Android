package com.example.finalproject;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class mylocationlistener implements LocationListener {
    private Context activetyContext;
    public mylocationlistener(Context cont)
    {
        activetyContext=cont;
    }

    @Override
    public void onLocationChanged(Location location) {

        Toast.makeText(activetyContext,location.getLatitude()+","+location.getLongitude(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

        Toast.makeText(activetyContext,"status changed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(activetyContext,"gps enabled",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onProviderDisabled(String provider) {

        Toast.makeText(activetyContext,"gps disabled",Toast.LENGTH_LONG).show();
    }
}
