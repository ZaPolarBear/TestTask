package com.zpb.testtask.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zpb.testtask.Repositories.CategoriesRepo;
import com.zpb.testtask.Repositories.FoodRepo;
import com.zpb.testtask.models.FoodDisplayModel;
import com.zpb.testtask.models.SearchModel;

import java.util.List;

public class SearchViewModel extends ViewModel {

    MutableLiveData<List<SearchModel>> searchModelList;
    CategoriesRepo categoriesRepo;

    public SearchViewModel(){
        categoriesRepo = new CategoriesRepo();
    }

    public LiveData<List<SearchModel>> GetCategories(){

        if(searchModelList == null){
            searchModelList = categoriesRepo.requestCategories();
        }

        return  searchModelList;
    }
}
