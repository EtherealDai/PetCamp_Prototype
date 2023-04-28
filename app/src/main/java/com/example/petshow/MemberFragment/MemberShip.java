package com.example.petshow.MemberFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.petshow.R;

public class MemberShip extends AppCompatActivity {
    private WeChatPay weChatPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_ship);
        TextView amount_text_view = findViewById(R.id.amount_text_view);
        Button pay_button = findViewById(R.id.pay_button);

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String payURL = " ";
                if(weChatPay.launcWechatPay(getApplicationContext(),payURL))
                {
                    Intent intent = new Intent(MemberShip.this, WeChatPay.class);
                    startActivity(intent);
                    amount_text_view.setText("您已经缴纳过本月会员费用");
                }else{
                    amount_text_view.setText("缴纳失败");
                }


            }
        });

    }
}