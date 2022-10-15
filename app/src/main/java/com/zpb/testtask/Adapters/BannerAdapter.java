package com.zpb.testtask.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.zpb.testtask.R;
import com.zpb.testtask.models.BannerModel;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    DatabaseReference reference;
    List<BannerModel> bannerList;

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_display_item, parent, false);
        Log.d("ADAPTER", "foodModel.getDescription()");

        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        BannerModel bannerModel = bannerList.get(position);

        Picasso.get().load(bannerModel.getImageUrl()).into(holder.bannerImage);


        Log.d("ADAPTER", bannerModel.getImageUrl());
    }

    public BannerAdapter(List<BannerModel> bannerList) {
        this.bannerList = bannerList;
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public void addToList(List<BannerModel> bannerList) {
        bannerList.addAll(bannerList);

    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        public ImageView bannerImage;


        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerImage = itemView.findViewById(R.id.banner);
        }
    }
}
