package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class User_ReportYoutubeChannel_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_report_youtube_channel);

        //이전 화면에서 intent 받아옴.
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userId = intent.getStringExtra("userId");

        //버튼 정보 받아옴.
        Button submitButton = (Button) findViewById(R.id.report_youtube_channel_submit_button);
        Button backButton = (Button) findViewById(R.id.report_youtube_channel_back_button);

        //editText 정보
        EditText reportContent = (EditText) findViewById(R.id.report_youtube_channel_content_editText);

        //링크 제출 버튼 이벤트
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

                Map<String, String> content = new HashMap<>();
                content.put("content", reportContent.getText().toString());

                databaseInstance.collection("user_report_channel")
                        .document(userName)
                        .set(content);

                Toast.makeText(User_ReportYoutubeChannel_Activity.this, "유튜브 채널 요청 완료", Toast.LENGTH_SHORT).show();
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

    }
}