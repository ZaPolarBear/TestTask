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
import com.zpb.testtask.Repositories.FoodRepo;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.List;

public class FoodViewModel extends ViewModel {

    MutableLiveData<List<FoodDisplayModel>> foodDisplayModel;
    FoodRepo foodRepo;

    public FoodViewModel(){
        foodRepo = new FoodRepo();
    }

    public LiveData<List<FoodDisplayModel>> GetFood(){

        if(foodDisplayModel == null){
            foodDisplayModel = foodRepo.requestFood();
        }

        return  foodDisplayModel;
    }

}
