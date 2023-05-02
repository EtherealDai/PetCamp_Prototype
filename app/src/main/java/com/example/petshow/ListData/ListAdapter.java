package com.example.petshow.ListData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.petshow.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ListData> {
    public ListAdapter(@NonNull Context context, int resource, @NonNull List<ListData> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        ListData listData = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_data, parent, false);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        title.setText(listData.getTitle());
        description.setText(listData.getDescription());
        return view;

    }
}
