package com.example.refrigerator;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class User_InquireIngredient_ViewHolder extends RecyclerView.ViewHolder {
    public TextView ingredientName;
    public TextView ingredientCount;
    public Button consumeButton;



    User_InquireIngredient_ViewHolder(Context context, View itemView) {
        super(itemView);
        ingredientName = itemView.findViewById(R.id.inquire_report_item_list_content_textView);
        ingredientCount = itemView.findViewById(R.id.ingredient_item_list_ingredient_count);
        consumeButton = itemView.findViewById(R.id.ingredient_item_list_consume_button);


    }
}
