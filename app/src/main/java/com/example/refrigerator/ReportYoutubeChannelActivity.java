package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ReportYoutubeChannelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_youtube_channel);

        //이전 화면에서 intent 받아옴.
        Intent intent = getIntent();

    }
}