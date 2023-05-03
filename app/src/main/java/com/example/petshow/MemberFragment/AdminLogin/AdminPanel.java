package com.example.petshow.MemberFragment.AdminLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.petshow.R;

public class AdminPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);


        TextView tv_common_request = findViewById(R.id.tv_common_request);
        TextView tv_suggestion_email = findViewById(R.id.tv_suggestion_email);
        TextView tv_update_info = findViewById(R.id.tv_update_info);


        tv_suggestion_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanel.this, SuggestionEmail.class);
                startActivity(intent);
            }
        });

        tv_common_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanel.this, CommonRequest.class);
                startActivity(intent);
            }
        });


    }
}