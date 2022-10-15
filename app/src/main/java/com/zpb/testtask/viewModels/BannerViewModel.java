package com.zpb.testtask.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zpb.testtask.Repositories.BannerRepo;
import com.zpb.testtask.Repositories.FoodRepo;
import com.zpb.testtask.models.BannerModel;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.List;

public class BannerViewModel extends ViewModel {

    MutableLiveData<List<BannerModel>> bannerDisplayModel;
    BannerRepo bannerRepo;

    public BannerViewModel(){
        bannerRepo = new BannerRepo();
    }

    public LiveData<List<BannerModel>> GetBanner(){

        if(bannerDisplayModel == null){
            bannerDisplayModel = bannerRepo.requestBanner();
        }

        return  bannerDisplayModel;
    }

}
