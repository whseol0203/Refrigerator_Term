package com.example.refrigerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.login_btn);
        Button registerButton = (Button) findViewById(R.id.register_btn);

        //id를 적는 TextBox;
        EditText idTextBox = (EditText) findViewById(R.id.login_id_textbox);
        //pwd 를 적는 TextBox;
        EditText pwdTextBox = (EditText) findViewById(R.id.login_pwd_textbox);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login login = new Login("sample name", idTextBox.getText().toString(), pwdTextBox.getText().toString(),"user");
                FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

                DocumentReference docRef = databaseInstance.collection("user_information")
                        .document(idTextBox.getText().toString());

                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    String inputPwd = login.getPwd();
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                //ID가 존재하고, 비밀번호가 일치하는경우.
                                if(inputPwd.equals(document.get("pwd").toString())){
                                    Intent intent = new Intent(getApplicationContext(), UserMainActivity.class);
                                    startActivity(intent);
                                    Log.d("Doc", "DocumentSnapshot data: " + document.get("pwd").toString());
                                }else{
                                    Toast.makeText(LoginActivity.this, "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
                                }


                            } else {
                                Toast.makeText(LoginActivity.this, "아이디가 없습니다.", Toast.LENGTH_SHORT).show();
                                Log.d("Doc", "No such document");
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "데이터베이스 오류.", Toast.LENGTH_SHORT).show();
                            Log.d("Doc", "get failed with ", task.getException());
                        }
                    }
                });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}