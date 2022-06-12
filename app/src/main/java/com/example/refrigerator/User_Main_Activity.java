package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User_Main_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_main);

        Intent intent = getIntent();
        TextView greeting = findViewById(R.id.textView8);
        String userName = intent.getStringExtra("userName");
        String userId = intent.getStringExtra("userId");

        greeting.setText("안녕하세요 "+ userName+" 님");

        //버튼 정보
        Button inquireIngredientButton = (Button) findViewById(R.id.user_main_inquire_ingredient);
        Button inquireRecipeButton = (Button) findViewById(R.id.user_main_inquire_recipe);
        Button reportErrorButton = (Button) findViewById(R.id.user_main_report);
        Button requestYoutubeChannelButton = (Button) findViewById(R.id.user_main_channel_request);
        Button logoutButton = (Button) findViewById(R.id.user_main_logout);

        //식재료 조회 요청 버튼 이벤트
        inquireIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_InquireIngredient_Activity.class);
                startActivity(intent);
            }
        });

        //레시피 조회 버튼 이벤트
        inquireRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_Main_Activity.class);
                startActivity(intent);
            }
        });

        //오류 신고 버튼 이벤트
        reportErrorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_ReportError_Activity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("userId",userId);
                startActivity(intent);
            }
        });

        //유튜브 채널 추가 요청 버튼 이벤트
        requestYoutubeChannelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), User_ReportYoutubeChannel_Activity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("userId",userId);
                startActivity(intent);
            }
        });

        //logout 버튼 이벤트
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
            }
        });
    }


}