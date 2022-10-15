package com.zpb.testtask.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.zpb.testtask.models.FoodDisplayModel;

import java.util.ArrayList;
import java.util.List;

public class FoodRepo {

    final MutableLiveData<List<FoodDisplayModel>> foodDisplayModel = new MutableLiveData<>();
    List<FoodDisplayModel> foodDisplayModelList = new ArrayList<>();

    public MutableLiveData<List<FoodDisplayModel>> requestFood() {
        CreateList();
        foodDisplayModel.postValue(foodDisplayModelList);
        return foodDisplayModel;
    }


    public void CreateList() {
        for (int i = 0; i < 4; i++) {
            FoodDisplayModel foodModel = new FoodDisplayModel("Best pizza",
                    "Delicious",
                    "99 Byn",
                    "Image");
            foodDisplayModelList.add(foodModel);
        }
    }
}
