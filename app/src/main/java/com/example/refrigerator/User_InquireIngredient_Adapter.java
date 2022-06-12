package com.example.refrigerator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class User_InquireIngredient_Adapter extends RecyclerView.Adapter<User_InquireIngredient_ViewHolder> {

    private ArrayList<String> arrayList;

    public User_InquireIngredient_Adapter() {
        arrayList = new ArrayList<String>();
    }

    @NonNull
    @Override
    public User_InquireIngredient_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.user_item_list_inquire_ingredient, parent, false); //ingredient_item_list받음.

        User_InquireIngredient_ViewHolder ingredientViewHolder = new User_InquireIngredient_ViewHolder(context, view);
        ingredientViewHolder.consumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //일단 보류
            }
        });
        return ingredientViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull User_InquireIngredient_ViewHolder ingredientViewHolder, int position) {
        String str = arrayList.get(position);
        String [] arr = str.split(" ");
        ingredientViewHolder.ingredientName.setText(arr[0]);
        ingredientViewHolder.ingredientCount.setText(arr[1]);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setArrayData(String strData) {
        arrayList.add(strData);
    }
}
