package com.zpb.testtask.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.zpb.testtask.models.BannerModel;

import java.util.ArrayList;
import java.util.List;

public class BannerRepo {

    final MutableLiveData<List<BannerModel>> bannerDisplayModel = new MutableLiveData<>();
    List<BannerModel> bannerModelList = new ArrayList<>();

    public MutableLiveData<List<BannerModel>> requestBanner() {
        CreateList();
        bannerDisplayModel.setValue(bannerModelList);
        return bannerDisplayModel;
    }

    public void CreateList() {
        for (int i = 0; i < 2; i++) {
            BannerModel bannerModel = new BannerModel("aaa");
            bannerModelList.add(bannerModel);
        }
    }
}
