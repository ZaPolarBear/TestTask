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
import com.zpb.testtask.CONST;
import com.zpb.testtask.R;
import com.zpb.testtask.models.BannerModel;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    List<BannerModel> bannerModelList;

    @NonNull
    @Override
    public BannerAdapter.BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.banner_item, parent, false);
        return new BannerAdapter.BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.BannerViewHolder holder, int position) {
        BannerModel bannerModel = bannerModelList.get(position);
        holder.banner.setVisibility(View.VISIBLE);
    }

    public BannerAdapter(final List<BannerModel> bannerModelList) {
        this.bannerModelList = bannerModelList;
    }

    @Override
    public int getItemCount() {
        return bannerModelList.size();
    }

    public void addToList(List<BannerModel> bannerModelList) {
        this.bannerModelList.clear();
        this.bannerModelList = bannerModelList;
        notifyDataSetChanged();

    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        public ImageView banner;


        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);

            banner = itemView.findViewById(R.id.banner);
        }
    }
}