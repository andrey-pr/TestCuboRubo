package com.kalashnyk.denys.testcuborubo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.kalashnyk.denys.testcuborubo.Config;
import com.kalashnyk.denys.testcuborubo.R;
import com.kalashnyk.denys.testcuborubo.app.ApiClient;
import com.kalashnyk.denys.testcuborubo.model.Store;
import com.kalashnyk.denys.testcuborubo.ui.fragments.StoreFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//, LoaderReceiver.Receiver
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Store> stores;
    final String TAG = "myLogs";
    StoreFragment storeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        loaderReceiver = new LoaderReceiver(new Handler());
//        loaderReceiver.setReceiver(this);
//        loaderReceiver = new LoaderReceiver(new Handler());
//        loaderReceiver.setReceiver(this);
//        Intent intent = new Intent(Intent.ACTION_SYNC, null, this, Service.class);
//        intent.putExtra("url", Config.REPLACE);
//        intent.putExtra("receiver", loaderReceiver);
//        startService(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            storeFragment = new StoreFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, storeFragment);
            fragmentTransaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            getRequestStore();
        } else if (id == R.id.nav_gallery) {
            //getActivityFromContext();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    private static Activity getActivityFromContext(AlertDialog dialog) {
//        if(dialog.getContext() instanceof Activity) {
//            return (Activity)dialog.getContext();
//        }
//        if(dialog.getContext() instanceof ContextWrapper &&
//                ((ContextWrapper)dialog.getContext()).getBaseContext() instanceof Activity) {
//            return  (Activity) ((ContextWrapper)dialog.getContext()).getBaseContext();
//        }
//        return null;
//    }
//    public void getFragmentTools()
//    {
//        InstrumentFragment  instrumentFragment = new InstrumentFragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.container, instrumentFragment);
//        fragmentTransaction.commit();
//    }
    private void getRequestStore() {
        stores = new ArrayList<>();
        Call<List<Store>> call = ApiClient.getStoreService().getStores("", 100);
        call.enqueue(new Callback<List<Store>>(){

            @Override
            public void onResponse(Response<List<Store>> response) {
                if (response.isSuccess()) {
                    System.out.println(response.body().toString());

                    stores = (ArrayList<Store>) response.body();
                    for (Object obj : stores) {

                        Store storeObj = (Store) obj;
                        Config._idStore = storeObj.getId();
                        Config._nameStore = storeObj.getName();
                        Config._addressStore = storeObj.getAddress();
                        Config._phoneStore = storeObj.getPhone();
                        Config._locationStore = storeObj.getLocation();
//                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(storeObj.getPhone()));
                        Log.v(TAG, "ResponseStore" + " " +
                                Config._idStore+ " " +
                                Config._nameStore + " " +
                                Config._addressStore + " " +
                                Config._phoneStore + " " +
                                Config._locationStore
                        );
                    }

                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

//    @Override
//    public void onReceiveResult(int resultCode, Bundle resultData) {
//        switch (resultCode) {
//            case Config.REPLACE:
////                getFragmentTools();
//                break;
//        }
//    }
}













//    private void getRequestInstrument() {
//        Call<List<Instruments>> call = ApiClient.getInstrumentService().getInstruments("", 100);
//        call.enqueue(new Callback<List<Instruments>>(){
//
//            @Override
//            public void onResponse(Response<List<Instruments>> response) {
//                if (response.isSuccess()) {
//                    System.out.println(response.body().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//    }