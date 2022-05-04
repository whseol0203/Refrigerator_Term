package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class IngredientActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    IngredientDialog ingredientDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);




        recyclerView = (RecyclerView) findViewById(R.id.recyceler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        adapter = new Adapter();

        adapter.setArrayData("당근 1");
        adapter.setArrayData("오이 2");
        adapter.setArrayData("귤 3");
        adapter.setArrayData("감 41");
        adapter.setArrayData("감자 100");
        adapter.setArrayData("당근 1");
        adapter.setArrayData("오이 2");
        adapter.setArrayData("귤 3");
        adapter.setArrayData("감 41");
        adapter.setArrayData("감자 100");
        adapter.setArrayData("당근 1");
        adapter.setArrayData("오이 2");
        adapter.setArrayData("귤 3");
        adapter.setArrayData("감 41");
        adapter.setArrayData("감자 100");
        adapter.setArrayData("당근 1");
        adapter.setArrayData("오이 2");
        adapter.setArrayData("귤 3");
        adapter.setArrayData("감 41");
        adapter.setArrayData("감자 100");

        recyclerView.setAdapter(adapter);
    }


}