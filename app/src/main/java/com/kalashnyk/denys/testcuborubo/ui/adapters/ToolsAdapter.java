package com.kalashnyk.denys.testcuborubo.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kalashnyk.denys.testcuborubo.R;
import com.kalashnyk.denys.testcuborubo.model.Instruments;

import java.util.ArrayList;

/**
 * Created by User on 17.09.2016.
 */
public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ToolsHolder> {
    private Context mContext;
    private ArrayList mToolsData;

    public ToolsAdapter(Context context, ArrayList toolData) {
        this.mContext = context;
        this.mToolsData = toolData;
    }

    static class ToolsHolder extends RecyclerView.ViewHolder {
        public CardView mCardTools;
        public ImageView mImageViewUrl;
        public TextView mTxtId;
        public TextView mTxtBrand;
        public TextView mTxtModel;
        public TextView mTxtType;
        public TextView mTxtPrice;
        public TextView mTxtQuantity;

        public ToolsHolder(View itemView) {
            super(itemView);
            this.mCardTools = (CardView) itemView.findViewById(R.id.card_view_instrument);
            this.mImageViewUrl = (ImageView) itemView.findViewById(R.id.image_view_image_url);
            this.mTxtId = (TextView) itemView.findViewById(R.id.txt_id);
            this.mTxtBrand = (TextView) itemView.findViewById(R.id.txt_brand);
            this.mTxtModel = (TextView) itemView.findViewById(R.id.txt_model);
            this.mTxtType = (TextView) itemView.findViewById(R.id.txt_type);
            this.mTxtPrice = (TextView) itemView.findViewById(R.id.txt_price);
            this.mTxtQuantity = (TextView) itemView.findViewById(R.id.txt_quantity);
        }
    }

    @Override
    public ToolsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_instruments, parent, false);
        ToolsHolder storeViewHolder = new ToolsHolder(view);
        return storeViewHolder;
    }

    @Override
    public void onBindViewHolder(ToolsHolder holder, int position) {
        final Instruments instruments = (Instruments) mToolsData.get(position);

//        Picasso
//                .with(getActivityFromContext(mContext))
//                .load(instruments.getImageUrl())
//                .into(holder.mImageViewUrl);
        holder.mImageViewUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivityFromContext(view.getContext()).getApplicationContext(), instruments.getImageUrl(), Toast.LENGTH_LONG).show();
            }
        });
        holder.mTxtBrand.setText(instruments.getBrand());
        holder.mTxtBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivityFromContext(view.getContext()).getApplicationContext(), instruments.getBrand(), Toast.LENGTH_LONG).show();
            }
        });
        holder.mTxtModel.setText(instruments.getModel());
        holder.mTxtModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivityFromContext(view.getContext()).getApplicationContext(), instruments.getModel(), Toast.LENGTH_LONG).show();
            }
        });
        holder.mTxtType.setText(instruments.getType());
        holder.mTxtType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivityFromContext(view.getContext()).getApplicationContext(), instruments.getType(), Toast.LENGTH_LONG).show();
            }
        });
        holder.mTxtPrice.setText(String.valueOf(instruments.getPrice()));
        holder.mTxtPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivityFromContext(view.getContext()).getApplicationContext(), String.valueOf(instruments.getPrice()), Toast.LENGTH_LONG).show();
            }
        });
        holder.mTxtQuantity.setText(String.valueOf(instruments.getQuantity()));
        holder.mTxtQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivityFromContext(view.getContext()).getApplicationContext(), String.valueOf(instruments.getQuantity()), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mToolsData.size();
    }

    public static AppCompatActivity getActivityFromContext(Context context) {
        if (context instanceof Activity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextWrapper &&
                ((ContextWrapper) context).getBaseContext() instanceof Activity) {
            return (AppCompatActivity) ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
