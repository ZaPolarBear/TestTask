package com.zpb.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.appbar.AppBarLayout;
import com.zpb.testtask.Adapters.BannerAdapter;
import com.zpb.testtask.Adapters.CategoriesAdapter;
import com.zpb.testtask.Adapters.FoodAdapter;
import com.zpb.testtask.Repositories.CategoriesRepo;
import com.zpb.testtask.models.BannerModel;
import com.zpb.testtask.models.FoodDisplayModel;
import com.zpb.testtask.models.SearchModel;
import com.zpb.testtask.viewModels.BannerViewModel;
import com.zpb.testtask.viewModels.FoodViewModel;
import com.zpb.testtask.viewModels.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private List<FoodDisplayModel> foodList = new ArrayList<>();
    private List<BannerModel> bannerModelList = new ArrayList<>();
    private List<SearchModel> searchModelList = new ArrayList<>();

    private RecyclerView FoodTab, BannerTab, SearchTab;

    private FoodViewModel foodViewModel = new FoodViewModel();
    private BannerViewModel bannerViewModel = new BannerViewModel();
    private SearchViewModel searchViewModel = new SearchViewModel();

    private FoodAdapter foodAdapter;
    private BannerAdapter bannerAdapter;
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitRecyclerViews();
        InitAdapters();



        foodViewModel.GetFood().observe(this, new Observer<List<FoodDisplayModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<FoodDisplayModel> foodDisplayModels) {
                foodAdapter.addToList(foodDisplayModels);

            }
        });

        bannerViewModel.GetBanner().observe(this, new Observer<List<BannerModel>>() {
            @Override
            public void onChanged(List<BannerModel> bannerModels) {
                BannerModel bannerModel = new BannerModel("aaa");
                bannerModels.add(bannerModel);
                bannerAdapter.addToList(bannerModels);
                Log.d("ADAPTERS", String.valueOf(foodAdapter.getItemCount()));
            }
        });

        searchViewModel.GetCategories().observe(this, new Observer<List<SearchModel>>() {
            @Override
            public void onChanged(List<SearchModel> searchModelList) {
                categoriesAdapter.addToList(searchModelList);
            }
        });
    }

    public void InitRecyclerViews() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(this);
        layoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager bannerLayoutManagerHorizontal = new LinearLayoutManager(this);
        bannerLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);

        SearchTab = findViewById(R.id.search_tab);
        FoodTab = findViewById(R.id.food_tab);
        BannerTab = findViewById(R.id.banner_tab);

        SearchTab.setLayoutManager(layoutManagerHorizontal);
        BannerTab.setLayoutManager(bannerLayoutManagerHorizontal);
        FoodTab.setLayoutManager(layoutManager);

    }


    public void InitAdapters(){
        foodAdapter = new FoodAdapter(foodList);
        FoodTab.setAdapter(foodAdapter);
        bannerAdapter = new BannerAdapter(bannerModelList);
        BannerTab.setAdapter(bannerAdapter);
        categoriesAdapter = new CategoriesAdapter(searchModelList);
        SearchTab.setAdapter(categoriesAdapter);
    }

}