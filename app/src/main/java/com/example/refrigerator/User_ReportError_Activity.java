package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User_ReportError_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_report_error);

        //이전 화면에서 intent 받아옴.
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userId = intent.getStringExtra("userId");

        //버튼 정보 받아옴.
        Button submitButton = (Button) findViewById(R.id.report_error_submit_button);
        Button backButton = (Button) findViewById(R.id.report_error_back_button);

        //양식
        EditText reportContent = (EditText) findViewById(R.id.report_error_report_content_editText);

        //오류 신고 버튼 이벤트
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

                Map<String, String> content = new HashMap<>();
                content.put("report error", reportContent.getText().toString());

                databaseInstance.collection("user_report")
                        .document(userName)
                        .set(content);
            }
        });

        //뒤로가기 버튼 이벤트
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_Main_Activity.class);
                startActivity(intent);
            }
        });

        Log.d("Doc", intent.getStringExtra("userName") + " " + intent.getStringExtra("userId"));


    }
}