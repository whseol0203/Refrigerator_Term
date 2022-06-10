package com.example.refrigerator;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {
    private ArrayList<String> arrayList;

    public IngredientAdapter() {
        arrayList = new ArrayList<String>();
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.ingredient_item_list, parent, false); //ingredient_item_list받음.

        IngredientViewHolder ingredientViewHolder = new IngredientViewHolder(context, view);
        return ingredientViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder ingredientViewHolder, int position) {
        String str = arrayList.get(position);
        String [] arr = str.split(" ");
        ingredientViewHolder.ingredientName.setText(arr[0]);
        ingredientViewHolder.ingredientCount.setText(arr[1]);
        ingredientViewHolder.ingredientDate.setText(arr[2]);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setArrayData(String strData) {
        arrayList.add(strData);
    }
}
