package com.example.derek.myspeedalerter;

import android.Manifest;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;

import android.media.MediaPlayer;


public class MainActivity extends FragmentActivity implements SetSpeedFragment.SetSpeedListener {

    private LocationManager locationManager;
    private LocationListener listener;

    private SetSpeedFragment setSpeedFragment;
    private DisplayFragment displayFragment;

    double currentSpeedLimitKmh;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.carhorn);
        setSpeedFragment = (SetSpeedFragment)getSupportFragmentManager().findFragmentById(R.id.setspeed_fragment);
        displayFragment = (DisplayFragment)getSupportFragmentManager().findFragmentById(R.id.display_fragment);

        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        // procedure when a new location is read
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                try {
                    GpsStamp theStamp = new GpsStamp(location.getSpeed(), location.getLatitude(), location.getLongitude());
                    displayFragment.displayMessages(theStamp.getSpeedKmH(), currentSpeedLimitKmh, mediaPlayer);


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Exception " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {
                Toast.makeText(getApplicationContext(), "Provider Enabled", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        configureButton();
    }


    // the listeners in the SetSpeedFragment class call back to here when a speed limit sign icon is pressed/clicked
    public void onButtonClick(double speedlimit) {
        currentSpeedLimitKmh = setSpeedFragment.getCurrentSpeedLimit();
    }

    void configureButton() {

        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 10);
            }
            return;
        }

        // here we set the minimum interval between location updates
        // the second argument in the requestLocationUpdates() method is the minimum interval, in milliseconds
        try {
            locationManager.requestLocationUpdates("gps", 5000, 0, listener);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problem updating GPS", Toast.LENGTH_LONG).show();

        }
    }
}
