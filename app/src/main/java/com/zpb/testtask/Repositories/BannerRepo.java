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
import com.zpb.testtask.CONST;
import com.zpb.testtask.models.BannerModel;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.ArrayList;
import java.util.List;

public class BannerRepo {

    final FirebaseDatabase database = FirebaseDatabase.getInstance(CONST.RealtimeDatabaseUrl);
    final DatabaseReference reference = database.getReference("Banner");

    final MutableLiveData<List<BannerModel>> bannerDisplayModel = new MutableLiveData<>();
    List<BannerModel> bannerModelList = new ArrayList<>();

    public MutableLiveData<List<BannerModel>> requestFood() {
        final int i = 1;
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    BannerModel bannerModel = new BannerModel(
//                            dataSnapshot.child("1").child("ImageUrl").getValue(String.class));
//                    bannerModelList.add(bannerModel);

                }
                bannerDisplayModel.postValue(bannerModelList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return bannerDisplayModel;
    }
}
