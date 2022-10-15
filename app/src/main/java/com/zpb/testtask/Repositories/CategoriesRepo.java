package com.zpb.testtask.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.zpb.testtask.models.FoodDisplayModel;
import com.zpb.testtask.models.SearchModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRepo {
    final MutableLiveData<List<SearchModel>> searchModel = new MutableLiveData<>();
    List<SearchModel> searchModelList = new ArrayList<>();

    public MutableLiveData<List<SearchModel>> requestCategories() {
        CreateList();
        searchModel.postValue(searchModelList);
        return searchModel;
    }


    public void CreateList() {
        for (int i = 0; i <= 5; i++) {
            SearchModel searchModel = new SearchModel("Pizza");
            searchModelList.add(searchModel);
        }
    }
}
