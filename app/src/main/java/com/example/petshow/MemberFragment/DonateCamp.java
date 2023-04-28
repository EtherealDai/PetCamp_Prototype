package com.example.petshow.MemberFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.petshow.R;

public class DonateCamp extends AppCompatActivity {
    private WeChatPay weChatPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_camp);
        TextView amount_text_view = findViewById(R.id.amount_text_view);
        Button pay_button = findViewById(R.id.pay_button);
        String text = "感谢您为猫猫和营地做出的贡献！";
        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weChatPay.launcWechatPay(getApplicationContext()," "))
                {
                    amount_text_view.setText(text+"捐赠成功！");
                }
                else
                {
                    amount_text_view.setText("捐赠失败");
                }
            }
        });

    }
}