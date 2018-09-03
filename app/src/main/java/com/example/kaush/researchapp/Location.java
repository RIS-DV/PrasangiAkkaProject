package com.example.kaush.researchapp;

/**
 * Created by applelab7 on 9/3/18.
 */

public class Location {
    private double lat;
    private double lan;

    public Location(double lat, double lan) {
        this.lat = lat;
        this.lan = lan;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLan() {
        return lan;
    }

    public void setLan(double lan) {
        this.lan = lan;
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lan=" + lan +
                '}';
    }
}
