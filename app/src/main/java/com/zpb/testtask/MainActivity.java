package com.zpb.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zpb.testtask.Adapters.FoodAdapter;
import com.zpb.testtask.models.BannerModel;
import com.zpb.testtask.models.FoodDisplayModel;
import com.zpb.testtask.viewModels.BannerViewModel;
import com.zpb.testtask.viewModels.FoodViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FoodViewModel foodViewModel = new FoodViewModel();
        BannerViewModel bannerViewModel = new BannerViewModel();
        RecyclerView banner;
        banner = findViewById(R.id.banner_tab);

        List<FoodDisplayModel> foodList = new ArrayList<>();

        FoodAdapter foodAdapter = new FoodAdapter(foodList);

        List<BannerModel> bannerList = new ArrayList<>();

        RecyclerView FoodTab;
        FoodTab = findViewById(R.id.food_tab);
        FoodTab.setAdapter(foodAdapter);

        foodViewModel.GetFood().observe(this, new Observer<List<FoodDisplayModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<FoodDisplayModel> foodDisplayModels) {
                foodAdapter.addToList(foodDisplayModels);
                foodAdapter.notifyDataSetChanged();

                Log.d("ADAPTER", String.valueOf(foodList));
            }
        });

//        bannerViewModel.GetBanner().observe(getViewLifecycleOwner(), new Observer<List<BannerModel>>() {
//            @Override
//            public void onChanged(List<BannerModel> bannerModels) {
//                bannerList.addAll(bannerModels);
//                Log.d("ADAPTER", bannerList.toString());
//                BannerModel bannerModel = bannerList.get(1);
//                Log.d("ADAPTER",bannerModel.getImageUrl());
//            }
//        });

        //   BannerAdapter bannerAdapter = new BannerAdapter(bannerList);
        //      banner.setAdapter(bannerAdapter);

    }
}