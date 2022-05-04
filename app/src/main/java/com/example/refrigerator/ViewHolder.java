package com.example.refrigerator;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
/*
* ViewHolder 는 재사용 될 뷰 객체의 처음 데이터를 기억하고 있는 객체임.
*
*
*
*
 */

class ViewHolder extends RecyclerView.ViewHolder {
    public TextView ingredientName;
    public TextView ingredientCount;
    public Button button;

    ViewHolder(Context context, View itemView) {
        super(itemView);
        ingredientName = itemView.findViewById(R.id.ingredientName);
        ingredientCount = itemView.findViewById(R.id.ingredientCount);
        button = itemView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String strText = ingredientName.getText().toString();
                Toast.makeText(context, strText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
