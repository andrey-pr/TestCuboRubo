package com.kalashnyk.denys.testcuborubo.model.Realm;

import io.realm.RealmObject;

/**
 * Created by User on 11.09.2016.
 */
public class LocationRealm extends RealmObject {
    public LocationRealm() {}

    private int mLatitude;
    private int mLongitude;

    public LocationRealm(int mLatitude, int mLongitude) {
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    public int getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(int mLatitude) {
        this.mLatitude = mLatitude;
    }

    public int getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(int mLongitude) {
        this.mLongitude = mLongitude;
    }
}
