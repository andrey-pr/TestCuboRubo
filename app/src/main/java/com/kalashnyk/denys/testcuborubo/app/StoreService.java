package com.kalashnyk.denys.testcuborubo.app;

import com.kalashnyk.denys.testcuborubo.model.Instruments;
import com.kalashnyk.denys.testcuborubo.model.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by User on 11.09.2016.
 */
public interface StoreService {

    @GET("/stores")
    Call<List<Store>> getStores(@Query("q") String q, @Query("limit") int limit);

//    @GET("/stores/{id}/instruments")
//    Call<List<Store>> getStoresTools(@Path("id") int id);
//
//    @GET("/stores?storeId=")
//    public void getStoresTools(@Query("/instruments") Callback<List<Instruments>> cb);

    @GET("/stores/{id}/instruments")
    Call<List<Instruments>> getStoresTools(@Path("id") int id);
//    @GET("/stores?storeId=" + Config.CLIENT_ID)
//    public void getRecentTracks(@Query("instruments[from]") String date, Callback<List<Instruments>> cb);

}
