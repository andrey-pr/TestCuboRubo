package com.kalashnyk.denys.testcuborubo.app;

import android.content.Context;

import com.kalashnyk.denys.testcuborubo.Config;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by User on 01.08.2016.
 */
public class ApiClient {
    private static final String ENDPOINT = Config.LINK_STORE;
    private static StoreService storeService;

//    public static void init(Context context) {
//        if (context == null)
//            throw new IllegalArgumentException("context cannot be null");
//
//        final Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(ENDPOINT)
//                .build();
//
//        storeService = retrofit.create(StoreService.class);
//    }
    public static void init(Context context) {
        if (context == null)
            throw new IllegalArgumentException("context cannot be null");

        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ENDPOINT)
                .build();

        storeService = retrofit.create(StoreService.class);
    }
    public static StoreService getStoreService() {
        if (storeService == null)
            throw new IllegalStateException("You must initialize ApiClient before calling getStoreService()");
        return storeService;
    }
    public static StoreService getInstrumentService() {
        if (storeService == null)
            throw new IllegalStateException("You must initialize ApiClient before calling getStoreService()");
        return storeService;
    }
}