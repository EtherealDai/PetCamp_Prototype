package com.example.petshow.MemberFragment.AdminLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petshow.Main2Activity;
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

        tv_update_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转回Main2Activity，并显示DailyFragment
                //并且显示Toast提示用户更新成功
                Toast toast = Toast.makeText(AdminPanel.this, "请在此处进行修改", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(AdminPanel.this, Main2Activity.class);
                intent.putExtra("fragment", "daily");
                startActivity(intent);

            }
        });


    }
}