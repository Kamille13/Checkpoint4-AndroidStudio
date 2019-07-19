package com.example.checkpoint4.Adapter;

import android.content.Context;
import android.support.v4.util.Consumer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.example.checkpoint4.R;
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
        for(User users : freakShow.getUsers()){
            tvUserFreak.append(users.getEmail()+"\n");
        }



        return convertView;
    }
}
