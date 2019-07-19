package com.example.checkpoint4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.checkpoint4.Adapter.FreakShowAdapter;
import com.example.checkpoint4.R;
import com.example.checkpoint4.VolleySingleton;
import com.example.checkpoint4.model.FreakShow;

import java.util.ArrayList;
import java.util.List;

public class FreakShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freak_show);
        Button btBack = findViewById(R.id.btBack);
        Button btArtist = findViewById(R.id.btArtists);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreakShowActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreakShowActivity.this, UserOnFreakActivity.class);
                startActivity(intent);
            }
        });

        final ListView lvFreakShow = findViewById(R.id.lvFreakShow);
        final List<FreakShow> freakShowsList = new ArrayList<>();
        VolleySingleton.getInstance(FreakShowActivity.this).getAllFreakShow(new Consumer<List<FreakShow>>() {
            @Override
            public void accept(List<FreakShow> freakShows) {
                for (FreakShow freakShow : freakShows) {
                    freakShowsList.add(new FreakShow(freakShow.getName(), freakShow.getDescription()));
                }
                FreakShowAdapter adapter = new FreakShowAdapter(FreakShowActivity.this, freakShows);
                lvFreakShow.setAdapter(adapter);
            }
        });
    }
}
