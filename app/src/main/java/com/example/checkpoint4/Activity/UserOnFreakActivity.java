package com.example.checkpoint4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.checkpoint4.Adapter.UserFreakAdapter;
import com.example.checkpoint4.R;
import com.example.checkpoint4.VolleySingleton;
import com.example.checkpoint4.model.FreakShow;
import com.example.checkpoint4.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserOnFreakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_on_freak);
        final ListView lvUserOnFreak = findViewById(R.id.lvUserOnFreak);
        final List<FreakShow> userFreaks = new ArrayList<>();

        VolleySingleton.getInstance(UserOnFreakActivity.this).getAllFreakShow(new Consumer<List<FreakShow>>() {
            @Override
            public void accept(List<FreakShow> freakShows) {
                for (FreakShow freakShow : freakShows) {
                    for (User users : freakShow.getUsers()) {
                        userFreaks.add(new FreakShow(freakShow.getName(), users.getEmail()));
                    }
                }
                UserFreakAdapter adapter = new UserFreakAdapter(UserOnFreakActivity.this, freakShows);
                lvUserOnFreak.setAdapter(adapter);
            }
        });
        Button btBack = findViewById(R.id.btRetour);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserOnFreakActivity.this, FreakShowActivity.class);
                startActivity(intent);
            }
        });
        Button btRefrech = findViewById(R.id.btRefresh);
        btRefrech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserOnFreakActivity.this, UserOnFreakActivity.class);
                startActivity(intent);
            }
        });
    }
}
