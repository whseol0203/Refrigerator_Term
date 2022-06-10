package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class IngredientActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    IngredientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

        Button backButton = (Button) findViewById(R.id.inquire_ingredient_back_button);

        recyclerView = (RecyclerView) findViewById(R.id.recyceler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        adapter = new IngredientAdapter();

        adapter.setArrayData("당근 2개 10일");
        adapter.setArrayData("사과 4개 4일");
        adapter.setArrayData("파 1개 5일");
        adapter.setArrayData("당근 2개 10일");
        adapter.setArrayData("당근 2개 10일");
        adapter.setArrayData("당근 2개 10일");
        adapter.setArrayData("사과 4개 4일");
        adapter.setArrayData("파 1개 5일");
        adapter.setArrayData("당근 2개 10일");
        adapter.setArrayData("당근 2개 10일");

        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserMainActivity.class);
                startActivity(intent);
            }
        });
    }


}