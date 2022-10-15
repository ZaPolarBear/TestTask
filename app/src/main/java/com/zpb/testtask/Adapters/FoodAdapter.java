package com.zpb.testtask.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zpb.testtask.R;
import com.zpb.testtask.models.FoodDisplayModel;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    DatabaseReference reference;
    List<FoodDisplayModel> foodList;

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_display_item, parent, false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodDisplayModel foodModel = foodList.get(position);
        holder.foodImage.setVisibility(View.VISIBLE);
        holder.foodDescription.setText(foodModel.getDescription());
        holder.foodName.setText(foodModel.getName());
        holder.foodPrice.setText(foodModel.getPrice());

        Log.d("ADAPTER", "foodModel.getDescription()");
    }

    public FoodAdapter(List<FoodDisplayModel> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void addToList(List<FoodDisplayModel> foodDisplayModelList) {
        foodList.addAll(foodDisplayModelList);

    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        public ImageView foodImage;
        public TextView foodDescription, foodName, foodPrice;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            foodDescription = itemView.findViewById(R.id.food_description);
            foodName = itemView.findViewById(R.id.food_name);
            foodPrice = itemView.findViewById(R.id.price_text);
        }
    }
}
