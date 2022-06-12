package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_main);

        //버튼 등록
        Button inquireUserRequestButton = (Button) findViewById(R.id.admin_main_inquire_user_request_button);
        Button crawlingYoutubeChannelButton = (Button) findViewById(R.id.admin_main_crawling_youtube_channel_button);
        Button addRecipeButton = (Button) findViewById(R.id.admin_main_add_recipe_button);
        Button logoutButton = (Button) findViewById(R.id.admin_main_logout_button);

        inquireUserRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Admin_InquireUserReport_Activity.class);
                startActivity(intent);
            }
        });

        crawlingYoutubeChannelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
            }
        });
    }



}