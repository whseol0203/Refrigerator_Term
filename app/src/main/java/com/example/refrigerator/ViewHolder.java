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
    public TextView userName;
    public TextView content;
    public TextView ingredientDate;
    public Button button;

    ViewHolder(Context context, View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.inquire_report_item_list_content_textView);
        content = itemView.findViewById(R.id.ingredient_item_list_ingredient_date);
        button = itemView.findViewById(R.id.ingredient_item_list_consume_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String strText = userName.getText().toString();
                Toast.makeText(context, strText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
