package com.example.petshow.MemberFragment.AdminLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        final String[] userName = {""};
        final String[] password = {""};
        username_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userName[0] = username_input.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password[0] = password_input.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        System.out.println("__"+ userName[0] +"__");
        System.out.println("__"+ password[0] +"__");

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName[0].equals("admin") && password[0].equals("admin")) {
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