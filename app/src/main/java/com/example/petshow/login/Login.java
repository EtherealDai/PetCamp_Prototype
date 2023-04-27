package com.example.petshow.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.petshow.Main2Activity;
import com.example.petshow.R;

public class Login extends AppCompatActivity {
    private Button btnSignUp;
    private Button btnLoginAsGuest;
    private Button btnForgetPassword;
    private EditText userName;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLoginAsGuest = findViewById(R.id.btnLoginAsGuest);
        btnForgetPassword = findViewById(R.id.btnForgetPassword);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().equals("")){
                    userName.setError("用户名不能为空");
                }else if(password.getText().toString().equals("")){
                    password.setError("密码不能为空");
                }else{
                    Intent intent = new Intent(Login.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
        });

        btnLoginAsGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到浏览器进行浏览
                jumpToPage(v);
            }
        });

        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameStr = userName.getText().toString();
                Intent intent = new Intent(Login.this, ForgetPassword.class);
                intent.putExtra("userName", userNameStr);
                startActivity(intent);
            }
        });
    }

    public void jumpToPage(View view) {
        String URL="https://mp.weixin.qq.com/s/06GG3YaBB3Z5etTLtZSvjQ";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse(URL));
        intent.setPackage("com.android.chrome");
        startActivity(intent);
    }
}