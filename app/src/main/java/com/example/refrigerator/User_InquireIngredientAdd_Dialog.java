package com.example.refrigerator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User_InquireIngredientAdd_Dialog extends Activity {
    private TextView stockIngredientTextView;
    private EditText stockIngredientEditText;
    private EditText stockIngredientCountEditText;
    private Button stockAddButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.user_popup_add_ingredient);

        //추가할 재료
        stockIngredientTextView = findViewById(R.id.ingredient_add_popup_title_textView);

        //추가할 재료 이름. editText
        stockIngredientEditText = findViewById(R.id.ingredient_add_popup_ingredient_editText);
        stockIngredientCountEditText = findViewById(R.id.ingredient_add_popup_count_editText);

        //버튼
        stockAddButton = findViewById(R.id.ingredient_add_popup_add_button);
        backButton = findViewById(R.id.ingredient_add_popup_back_button);

        stockAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
