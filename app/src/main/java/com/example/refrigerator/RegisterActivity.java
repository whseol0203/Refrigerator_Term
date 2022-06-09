package com.example.refrigerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button backButton = (Button) findViewById(R.id.register_back_btn);
        Button registerButton = (Button) findViewById(R.id.register_register_button);
        //textbox 정보
        EditText nameTextBox = (EditText) findViewById(R.id.register_name_textbox);
        EditText idTextBox = (EditText) findViewById(R.id.register_id_textbox);
        EditText pwdTextBox = (EditText) findViewById(R.id.register_pwd_textbox);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register register = new Register(nameTextBox.getText().toString(),
                        idTextBox.getText().toString(),
                        pwdTextBox.getText().toString(),
                        1);
                register.doRegister(new DB());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}