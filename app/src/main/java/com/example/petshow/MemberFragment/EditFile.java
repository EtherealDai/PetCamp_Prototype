//这个Activity已经完成了，无需再改动了。
package com.example.petshow.MemberFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petshow.Main2Activity;
import com.example.petshow.R;

import org.w3c.dom.Text;

public class EditFile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_file);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userEmail = intent.getStringExtra("userEmail");

        ImageView imageViewAvatar = findViewById(R.id.imageViewAvatar);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);

        imageViewAvatar.setImageResource(R.mipmap.ic_launcher);
        //显示用户的用户名和邮箱
        editTextEmail.setHint(userEmail);
        editTextName.setHint(userName);


        //监听用户名和邮箱的更改
        final String[] newUserName = {""};
        final String[] newUserEmail = {""};
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //获取用户更改的新用户名和邮箱
                newUserName[0] = editTextName.getText().toString();
                newUserEmail[0] = editTextEmail.getText().toString();
                System.out.println("--"+ newUserName[0] +"--");
                System.out.println("--"+ newUserEmail[0] +"--");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        //保存
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存新的用户名和邮箱
                //返回个人信息界面
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newUserName", newUserName[0]);
                returnIntent.putExtra("newUserEmail", newUserEmail[0]);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}