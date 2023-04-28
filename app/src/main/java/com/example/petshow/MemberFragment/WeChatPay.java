package com.example.petshow.MemberFragment;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class WeChatPay {
    public static boolean launcWechatPay(Context context,String payURL) {
        try{
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.tencent.mm", PackageManager.GET_ACTIVITIES);
        }catch (PackageManager.NameNotFoundException e){
            Toast toast = Toast.makeText(context, "您尚未安装微信", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse(payURL));
        context.startActivity(intent);
        return true;
    }
}
