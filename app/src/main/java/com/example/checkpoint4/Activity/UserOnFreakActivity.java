package com.example.checkpoint4.Activity;

import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.checkpoint4.Adapter.FreakShowAdapter;
import com.example.checkpoint4.Adapter.UserFreakAdapter;
import com.example.checkpoint4.R;
import com.example.checkpoint4.VolleySingleton;
import com.example.checkpoint4.model.FreakShow;

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
                for (FreakShow freakShow : freakShows){
                    userFreaks.add(new FreakShow(freakShow.getName(),freakShow.getUsers()));
                    Toast.makeText(UserOnFreakActivity.this,freakShow.getName() + freakShow.getUsers() , Toast.LENGTH_LONG).show();
                }
                UserFreakAdapter adapter = new UserFreakAdapter(UserOnFreakActivity.this, freakShows);
                lvUserOnFreak.setAdapter(adapter);
            }
        });
    }
}
