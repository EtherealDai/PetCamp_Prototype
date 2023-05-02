package com.example.petshow.MemberFragment.AdminLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.petshow.ListData.ListAdapter;
import com.example.petshow.ListData.ListData;
import com.example.petshow.R;

import java.util.ArrayList;
import java.util.List;

public class SuggestionEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_email);
        ListView email_list = findViewById(R.id.email_list);
        List<ListData> listData = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listData.add(new ListData("Email " + i, "Email " + i + " description"));
        }
        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_data, listData);
        email_list.setAdapter(listAdapter);

        Button delete_button = findViewById(R.id.delete_button);
        Button reply_button = findViewById(R.id.reply_button);

        email_list.setOnItemClickListener((parent, view, position, id) -> {
            listData.get(position).setSelected(!listData.get(position).isSelected());
            listAdapter.notifyDataSetChanged();
        });

        //As the button clicked, the selected emails will be deleted from the list
        delete_button.setOnClickListener(v -> {
            for(int i = 0; i < listData.size(); i++){
                if(listData.get(i).isSelected()){
                    listData.remove(i);
                    i--;
                }
            }
            listAdapter.notifyDataSetChanged();
            Toast toast = Toast.makeText(SuggestionEmail.this, "删除邮件成功", Toast.LENGTH_SHORT);
            toast.show();
        });

        reply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < listData.size(); i++){
                    if(listData.get(i).isSelected()){
                        listData.remove(i);
                        i--;
                    }
                }
                listAdapter.notifyDataSetChanged();
                Intent intent = new Intent(SuggestionEmail.this, ReplyEmail.class);
                startActivity(intent);
            }
        });
    }
}