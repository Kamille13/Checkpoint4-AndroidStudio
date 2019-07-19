package com.example.checkpoint4.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Consumer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.checkpoint4.Activity.UserOnFreakActivity;
import com.example.checkpoint4.R;
import com.example.checkpoint4.VolleySingleton;
import com.example.checkpoint4.model.FreakShow;
import com.example.checkpoint4.model.User;

import java.util.List;

public class UserFreakAdapter extends ArrayAdapter {

    public UserFreakAdapter(Context context, List<FreakShow> freakShows) {
        super(context, 0, freakShows);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.user_freak_item, parent, false);
        }
        final FreakShow freakShow = (FreakShow) getItem(position);
        TextView tvFreakShowName = convertView.findViewById(R.id.tvFreakName);
        tvFreakShowName.setText(freakShow.getName());
        TextView tvUserFreak = convertView.findViewById(R.id.tvUserOnFreak);
        for (User users : freakShow.getUsers()) {
            tvUserFreak.append(users.getEmail() + "\n");
        }
        final Button btDelete = convertView.findViewById(R.id.btDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolleySingleton.getInstance(parent.getContext()).deleteOneCollectPoint(freakShow.getId(), new Consumer<FreakShow>() {
                    @Override
                    public void accept(FreakShow freakShow) {
                    }
                });
            }
        });

        return convertView;
    }
}
