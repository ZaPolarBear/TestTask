package com.zpb.testtask.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zpb.testtask.R;
import com.zpb.testtask.models.FoodDisplayModel;
import com.zpb.testtask.models.SearchModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{
    List<SearchModel> searchModelList;

    @NonNull
    @Override
    public CategoriesAdapter.CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_item, parent, false);
        return new CategoriesAdapter.CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.CategoriesViewHolder holder, int position) {
        SearchModel searchModel = searchModelList.get(position);
        holder.search.setText(searchModel.getSearchTag());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.search.setBackgroundResource(R.drawable.search_item_default);
                Toast.makeText(view.getContext(), "Category " + searchModel.getSearchTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public CategoriesAdapter(final List<SearchModel> searchModelList) {
        this.searchModelList = searchModelList;
    }

    @Override
    public int getItemCount() {
        return searchModelList.size();
    }

    public void addToList(List<SearchModel> foodDisplayModelList) {
        this.searchModelList.clear();
        this.searchModelList = foodDisplayModelList;
        notifyDataSetChanged();

    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        public TextView search;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            search = itemView.findViewById(R.id.search_text);
        }
    }
}
