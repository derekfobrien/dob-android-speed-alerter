package com.example.derek.myspeedalerter;

public class GpsStamp {
    private double speedMetresPerSec;
    private double latitude;
    private double longitude;

    public GpsStamp(double speedMetresPerSec, double latitude, double longitude) {
        this.speedMetresPerSec = speedMetresPerSec;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public double getSpeedKmH() {
        // return the speed in kilometres per hour as a double number
        return speedMetresPerSec * 3.6;
    }

    public String getSpeedKmHOneDP() {
        // return the speed in km/h to one place of decimals
        return String.format("%1.1f", speedMetresPerSec * 3.6);
    }

    public double getLatitude() {
        // return the latitude as a double number
        return latitude;
    }

    public String getLatitudeTo6DP() {
        return String.format("%1.6f", (float)latitude);
    }

    public double getLongitude() {
        // return the longitude as a double number
        return longitude;
    }

    public String getLongitudeTo6DP() {
        return String.format("%1.6f", (float)longitude);
    }

    public String getSpeedKmHString()
    {
        // return the speed in kilometres per hour as a string, to one place of decimals
        return String.format("%1.1f km/h", speedMetresPerSec * 3.6);
    }

    public String getLatitudeString() {
        // return the latitude as a string, formatted "0.000000 N/S"
        String ns = "";
        if (latitude < 0) {
            ns = " S";
        } else if (latitude > 0) {
            ns = " N";
        }

        double abslat = Math.abs(latitude);
        return String.format("%1.6f", (float)abslat) + ns;
    }

    public String getLongitudeString() {
        // return the longitude as a string, formatted "0.000000 W/E"
        String ew = "";
        if (longitude < 0) {
            ew = " W";
        } else if (longitude > 0) {
            ew = " E";
        }

        double abslong = Math.abs(longitude);
        return String.format("%1.6f", (float)abslong) + ew;
    }

    public String getFullCoords() {
        // return both the longitude and longitude on one string
        return "(" + getLatitudeString() + ", " + getLongitudeString() + ")";
    }

}