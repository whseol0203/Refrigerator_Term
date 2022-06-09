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
     * @param userInfo
     */
    public void addUserInfo(UserInfo userInfo){

        Map<String, String> user = new HashMap<>();
        user.put("username", userInfo.getUserName());
        user.put("pwd", userInfo.getPwd());


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
