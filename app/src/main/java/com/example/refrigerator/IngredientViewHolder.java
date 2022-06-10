package com.example.refrigerator;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class IngredientViewHolder extends RecyclerView.ViewHolder {
    public TextView ingredientName;
    public TextView ingredientDate;
    public TextView ingredientCount;
    public Button consumeButton;

    IngredientViewHolder(Context context, View itemView) {
        super(itemView);
        ingredientName = itemView.findViewById(R.id.ingredient_item_list_ingredient_name);
        ingredientDate = itemView.findViewById(R.id.ingredient_item_list_ingredient_date);
        ingredientCount = itemView.findViewById(R.id.ingredient_item_list_ingredient_count);
        consumeButton = itemView.findViewById(R.id.ingredient_item_list_consume_button);

        consumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
