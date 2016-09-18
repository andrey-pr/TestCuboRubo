package com.kalashnyk.denys.testcuborubo.app;

import android.app.Application;

/**
 * Created by User on 11.09.2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        ApiClient.init(this);
        super.onCreate();
    }
}
