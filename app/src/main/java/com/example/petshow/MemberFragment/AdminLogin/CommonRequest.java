package com.example.petshow.MemberFragment.AdminLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.petshow.ListData.ListAdapter;
import com.example.petshow.ListData.ListData;
import com.example.petshow.R;

import java.util.ArrayList;
import java.util.List;

public class CommonRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_request);
        ListView request_list = findViewById(R.id.request_list);
        List<ListData> listData = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listData.add(new ListData("Request " + i, "Request " + i + " description"));
        }
        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_data, listData);
        request_list.setAdapter(listAdapter);

        Button btn_agree = findViewById(R.id.btn_agree);
        Button btn_refuse = findViewById(R.id.btn_refuse);

        request_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listData.get(position).setSelected(!listData.get(position).isSelected());
                listAdapter.notifyDataSetChanged();
            }
        });

        //As the button clicked, the selected requests will be deleted from the list
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < listData.size(); i++){
                    if(listData.get(i).isSelected()){
                        listData.remove(i);
                        i--;
                    }
                }
                listAdapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(CommonRequest.this, "同意申请", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btn_refuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < listData.size(); i++){
                    if(listData.get(i).isSelected()){
                        listData.remove(i);
                        i--;
                    }
                }
                listAdapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(CommonRequest.this, "拒绝申请", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}