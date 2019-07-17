package com.example.checkpoint4;

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

        ListView lvFreakShow = findViewById(R.id.lvFreakShow);

        List<FreakShow> freakShows = new ArrayList<>();
        freakShows.add(new FreakShow("Wild Freak Show Toulouse","Les wilders les plus bizarres du sud !"));
        freakShows.add(new FreakShow("Wild Freak Show Paris","Les wilders les plus petits du monde !"));
        freakShows.add(new FreakShow("Wild Freak Show Marseille","Les wilders les plus fou du sud !"));
        freakShows.add(new FreakShow("Wild Freak Show LaLoupe","Les wilders les plus bizarres du monde !"));

        FreakShowAdapter adapter = new FreakShowAdapter(FreakShowActivity.this, freakShows);
        lvFreakShow.setAdapter(adapter);
    }
}
