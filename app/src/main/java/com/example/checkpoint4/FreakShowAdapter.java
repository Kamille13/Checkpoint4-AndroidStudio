package com.example.checkpoint4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.checkpoint4.model.FreakShow;

import java.util.List;

public class FreakShowAdapter extends ArrayAdapter<FreakShow> {

    public FreakShowAdapter(Context context, List<FreakShow> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.freak_show_item, parent, false);
        }
        FreakShow freakShow = getItem(position);
        TextView tvFreakShowName = convertView.findViewById(R.id.tvName);
        tvFreakShowName.setText(freakShow.getName());
        TextView tvFreakShowDescription = convertView.findViewById(R.id.tvDescription);
        tvFreakShowDescription.setText(freakShow.getDescription());

        return convertView;
    }
}
