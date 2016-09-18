package com.kalashnyk.denys.testcuborubo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 11.09.2016.
 */
public class Location {

    @SerializedName("latitude")
    private int latitude;
    @SerializedName("longitude")
    private int longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {

    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
