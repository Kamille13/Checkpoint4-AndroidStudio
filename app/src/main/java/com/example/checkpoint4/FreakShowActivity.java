package com.example.checkpoint4;

import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.checkpoint4.model.FreakShow;

import java.util.ArrayList;
import java.util.List;

public class FreakShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freak_show);

        final ListView lvFreakShow = findViewById(R.id.lvFreakShow);
        final List<FreakShow> freakShowsList = new ArrayList<>();
        VolleySingleton.getInstance(FreakShowActivity.this).getAllFreakShow(new Consumer<List<FreakShow>>() {
            @Override
            public void accept(List<FreakShow> freakShows) {
                for(FreakShow freakShow : freakShows){
                    freakShowsList.add(new FreakShow(freakShow.getName() , freakShow.getDescription()));
                }
                FreakShowAdapter adapter = new FreakShowAdapter(FreakShowActivity.this, freakShows);
                lvFreakShow.setAdapter(adapter);
            }
        });
    }
}
