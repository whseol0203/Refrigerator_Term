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

        adapter.setArrayData("A A가잘안돼요.");
        adapter.setArrayData("B B유튜브채널링크");
        adapter.setArrayData("C C가잘안돼요.");
        adapter.setArrayData("D D가잘안돼요.");
        adapter.setArrayData("E E유튜브채널링크");
        adapter.setArrayData("F ㅁ");
        adapter.setArrayData("G ㅁ");
        adapter.setArrayData("H ㅁ");
        adapter.setArrayData("I ㅁ");



        recyclerView.setAdapter(adapter);
    }


}