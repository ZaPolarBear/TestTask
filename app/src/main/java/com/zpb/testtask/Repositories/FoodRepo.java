package com.zpb.testtask.Repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zpb.testtask.Generator;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodRepo {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference reference = database.getReference("Food");
    final MutableLiveData<List<FoodDisplayModel>> foodDisplayModel = new MutableLiveData<>();
    List<FoodDisplayModel> foodDisplayModelList = new ArrayList<>();

    public MutableLiveData<List<FoodDisplayModel>> requestFood() {

        CreateList();
        foodDisplayModel.postValue(foodDisplayModelList);
        Log.d("ADAPTERS", String.valueOf(foodDisplayModelList.get(1).getName()));
        return foodDisplayModel;
    }


    public void CreateList() {
        for (int i = 0; i < 10; i++) {
            FoodDisplayModel foodModel = new FoodDisplayModel("aaa", "aaa", "aaa", "aaa");
            foodDisplayModelList.add(foodModel);
        }
    }
}
