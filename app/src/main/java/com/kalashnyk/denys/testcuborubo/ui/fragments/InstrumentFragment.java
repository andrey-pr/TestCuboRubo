package com.kalashnyk.denys.testcuborubo.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kalashnyk.denys.testcuborubo.Config;
import com.kalashnyk.denys.testcuborubo.R;
import com.kalashnyk.denys.testcuborubo.app.ApiClient;
import com.kalashnyk.denys.testcuborubo.model.Instruments;
import com.kalashnyk.denys.testcuborubo.model.Realm.ToolsRealm;
import com.kalashnyk.denys.testcuborubo.ui.adapters.ToolsAdapter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 13.09.2016.
 */
public class InstrumentFragment extends Fragment {

    private Context context = getActivity();
    private RecyclerView recyclerTools;
    private ArrayList<Instruments> instrumentses;
    private ToolsAdapter mAdapterTools;
    private ArrayList mData;
    private RecyclerView.LayoutManager mLayoutManager;
    final String TAG = "myLogs";
    private ArrayList<ToolsRealm> realmToolsData;
    private Realm realm;
    private ToolsRealm toolsRealm;
    int myInt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_instruments, container, false);
        Bundle bundle = this.getArguments();
        myInt = bundle.getInt("key");
//        Config data = new Config();
//        mData = data.getToolsData();
        instrumentses = new ArrayList<>();
        getRequestTools(instrumentses);
        recyclerTools = (RecyclerView) v.findViewById(R.id.recycler_view_tools);
        recyclerTools.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerTools.setLayoutManager(mLayoutManager);
        mAdapterTools = new ToolsAdapter(context, instrumentses);
        recyclerTools.setAdapter(mAdapterTools);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    private void getRequestTools(final ArrayList tools) {
        realmToolsData = new ArrayList<>();
        Call<List<Instruments>> call = ApiClient.getStoreService().getStoresTools(myInt);
        call.enqueue(new Callback<List<Instruments>>() {
            @Override
            public void onResponse(Response<List<Instruments>> response) {
                if (response.isSuccess()) {
                        System.out.println(response.body().toString());
                        List<Instruments> testList = response.body();
                    for (Object obj : testList) {
                        Instruments toolsObj = (Instruments) obj;
                        Config._idStore = toolsObj.getId();
                        Config._brandInstrument = toolsObj.getBrand();
                        Config._modelInstrument = toolsObj.getModel();
                        Config._imageUrlInstrument = toolsObj.getImageUrl();
                        Config._typeInstrument = toolsObj.getType();
                        Config._priceInstrument = toolsObj.getPrice();
                        Config._quantityInstrument = toolsObj.getQuantity();
                }
                    Log.v(TAG, "ResponseTools" + " " +
                            Config._idInstrument + " " +
                            Config._brandInstrument + " " +
                            Config._modelInstrument + " " +
                            Config._imageUrlInstrument + " " +
                            Config._typeInstrument + " " +
                            String.valueOf(Config._priceInstrument) + " " +
                            String.valueOf(Config._quantityInstrument)
                    );
                    Log.d("ToolsFromStore", response.body().toString());
                    realm.beginTransaction();
                    toolsRealm = realm.createObject(ToolsRealm.class);
                    if(Config._idInstrument != 0){
                        toolsRealm.setmId(Config._idInstrument);
                    }
                    if(Config._brandInstrument != null){
                        toolsRealm.setmBrand(Config._brandInstrument);
                    }
                    if(Config._modelInstrument != null){
                        toolsRealm.setmModel(Config._modelInstrument);
                    }
                    if(Config._imageUrlInstrument != null){
                        toolsRealm.setmImageUrl(Config._imageUrlInstrument);
                    }
                    if(Config._typeInstrument != null){
                        toolsRealm.setmType(Config._typeInstrument);
                    }
                    if(Config._priceInstrument != 0.0){
                        toolsRealm.setmPrice(Config._priceInstrument);
                    }
                    if(Config._quantityInstrument != 0){
                        toolsRealm.setmQuantity(Config._quantityInstrument);
                    }
                    realmToolsData.add(toolsRealm);
                    realm.commitTransaction();

                    realm.beginTransaction();
                    RealmResults<ToolsRealm> result = realm.where(ToolsRealm.class).findAll();
                    ToolsRealm toolsRealm = result.last();
                    Log.v(TAG, "realmDBToolsLast" + " " + toolsRealm);
                    realm.commitTransaction();

                    recyclerTools.setAdapter(mAdapterTools);
                    instrumentses.clear();
                    instrumentses.addAll(response.body());
                    mAdapterTools.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}


