package com.example.refrigerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class User_InquireIngredient_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    User_InquireIngredient_Adapter adapter;
    Object tempKey;

    public void addIngredient(String content){
        this.adapter.setArrayData(content);
        recyclerView.setAdapter(adapter);
    }

    public interface Callback {
        void success(String data);
        void fail(String errorMessage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_inquire_ingredient);



        //버튼
        Button backButton = (Button) findViewById(R.id.inquire_report_back_button);
        Button addButton = (Button) findViewById(R.id.inquire_report_remove_button);

        recyclerView = (RecyclerView) findViewById(R.id.inquire_report_recyceler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        //데이터베이스에서 불러옴. 보류
        FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

        adapter = new User_InquireIngredient_Adapter();

        databaseInstance.collection("user_ingredients")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Set tempSet;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Doc", document.getId() + " => " + document.getData());
                                for(Object key:  document.getData().entrySet().toArray()){
                                    adapter.setArrayData(key.toString());
                                    Log.d("Doc", key.toString());
                                }
                            }
                        } else {
                            Log.d("Doc", "Error getting documents: ", task.getException());
                        }
                    }
                });


        Log.d("Doc", "Error getting documents: ");


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_Main_Activity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_InquireIngredientAdd_Dialog.class);
                startActivity(intent);
            }
        });
    }



}