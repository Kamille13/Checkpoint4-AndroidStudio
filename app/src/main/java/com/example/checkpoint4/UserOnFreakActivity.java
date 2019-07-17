package com.example.checkpoint4;

import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.checkpoint4.model.FreakShow;
import com.example.checkpoint4.model.User;

import java.util.List;

public class UserOnFreakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_on_freak);

        VolleySingleton.getInstance(UserOnFreakActivity.this).getAllFreakShow(new Consumer<List<FreakShow>>() {
            @Override
            public void accept(List<FreakShow> freakShows) {
                for (FreakShow freakShow : freakShows){
                    Toast.makeText(UserOnFreakActivity.this,freakShow.getName() + freakShow.getUsers().toString() , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
