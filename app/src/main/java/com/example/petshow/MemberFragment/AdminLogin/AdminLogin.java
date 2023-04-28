package com.example.petshow.MemberFragment.AdminLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petshow.R;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        EditText username_input = findViewById(R.id.username_input);
        EditText password_input = findViewById(R.id.password_input);
        Button login_button = findViewById(R.id.login_button);

        String userName = username_input.getText().toString();
        String password = password_input.getText().toString();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.equals("admin") && password.equals("admin")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "管理员登陆成功", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(AdminLogin.this, AdminPanel.class);
                    startActivity(intent);
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "管理员权限错误", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}