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
                Login login = new Login("sample name", idTextBox.getText().toString(), pwdTextBox.getText().toString(),1);
                FirebaseFirestore databaseInstance = FirebaseFirestore.getInstance();

                DocumentReference docRef = databaseInstance.collection("user_information")
                        .document(idTextBox.getText().toString());

                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Intent intent = new Intent(getApplicationContext(), UserMainActivity.class);
                                startActivity(intent);
                                Log.d("Doc", "DocumentSnapshot data: " + document.getData());
                            } else {
                                Log.d("Doc", "No such document");
                            }
                        } else {
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