package com.example.refrigerator;
import static android.os.SystemClock.sleep;

import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DB {
    FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

    /**
     * 유저 정보를 추가
     * 추가되는 정보는 닉네임, 비밀번호, 유저 모드
     * @param userInfo
     */
    public void addUserInfo(UserInfo userInfo){

        Map<String, String> user = new HashMap<>();
        user.put("user_name", userInfo.getUserName());
        user.put("pwd", userInfo.getPwd());
        user.put("user_mode",userInfo.getUserMode());


        databaseInstance.collection("user_information")
                .document(userInfo.getId())
                .set(user);
    }

    /**
     * Database의 document(id) 를 가져옴.
     * @param userInfo
     * @return DocumentReference
     */
    public DocumentReference getUserInfo(UserInfo userInfo){
        String userId = userInfo.getId();

        DocumentReference docRef = databaseInstance.collection("user_information")
                .document(userId);

        return docRef;
    }
}
