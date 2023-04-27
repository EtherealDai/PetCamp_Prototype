package com.example.petshow.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petshow.R;

public class ForgetPassword extends AppCompatActivity {
    private EditText userNameForgetPassword;
    private Button btnSendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        userNameForgetPassword = findViewById(R.id.userNameForgetPassword);
        String userName = getIntent().getStringExtra("userName");
        userNameForgetPassword.setText(userName);

        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgetPassword.this, "验证邮件已发送。", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgetPassword.this, EmailWait.class);
                startActivity(intent);
            }
        });
    }
}