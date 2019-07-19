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
import com.example.checkpoint4.UserSingleton;
import com.example.checkpoint4.VolleySingleton;
import com.example.checkpoint4.model.FreakShow;
import com.example.checkpoint4.model.User;

import java.util.List;

public class FreakShowAdapter extends ArrayAdapter<FreakShow> {

    public FreakShowAdapter(Context context, List<FreakShow> freakShows) {
        super(context, 0, freakShows);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.freak_show_item, parent, false);
        }
        final FreakShow freakShow = getItem(position);
        TextView tvFreakShowName = convertView.findViewById(R.id.tvName);
        tvFreakShowName.setText(freakShow.getName());
        TextView tvFreakShowDescription = convertView.findViewById(R.id.tvDescription);
        tvFreakShowDescription.setText(freakShow.getDescription());

        Switch btParticipe = convertView.findViewById(R.id.btParticipe);
        btParticipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSingleton userSingleton = UserSingleton.getInstance();
                VolleySingleton.getInstance(parent.getContext()).postFreakShowUser(userSingleton.getUser(), freakShow, new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                    }
                });
            }
        });
        return convertView;
    }
}
