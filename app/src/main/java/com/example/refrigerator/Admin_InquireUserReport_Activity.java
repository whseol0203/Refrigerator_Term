package com.example.refrigerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Set;

public class Admin_InquireUserReport_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_inquire_report);

        FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

        databaseInstance.collection("user_report")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Doc", "report 목록 " + document.getData());
                            }
                        } else {
                            Log.d("Doc", "Error getting documents: ", task.getException());
                        }
                    }
                });
        //

        Button back = (Button) findViewById(R.id.inquire_report_back_button);
        
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Admin_Main_Activity.class);
                startActivity(intent);
            }
        });
    }
}