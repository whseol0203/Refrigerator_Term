package com.example.refrigerator;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.Map;


public class Login extends UserInfo{
    public Login(String name, String id, String pwd, String userMode){
        super(name,id,pwd,userMode);
    }

    /* 원래는 로그인을 담당하는 함수가 있어야 하나, 데이터베이스에서 데이터를 불러오는 과정에서
    비동기 함수가 실행되고 그로 인한 기술적 한계로 Activity로 구현부를 옮김.
     */
}
