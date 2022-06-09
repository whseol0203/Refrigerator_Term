package com.example.refrigerator;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class IngredientDialog extends Dialog {
    private TextView stock_text;
    private TextView stock_count;
    private Button add;
    private Button sub;

    public IngredientDialog(@NonNull Context context, String contents){
        super(context);
        setContentView(R.layout.popup_ingredient);

        stock_text = findViewById(R.id.stock_text);
        stock_count = findViewById(R.id.stock_count);

        sub = findViewById(R.id.sub_btn);
    }
}
