package com.example.checkpoint4;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.checkpoint4.model.User;


public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        final EditText etEmail = findViewById(R.id.etInscriptionEmail);
        final EditText etPassword = findViewById(R.id.etInscriptionPassword);
        Button btInscription = findViewById(R.id.btInscrire);

        btInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    new AlertDialog.Builder(InscriptionActivity.this)
                            .setTitle("Erreur")
                            .setMessage("Veuillez renseigner votre email et mot de passe")
                            .show();
                }
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);

                VolleySingleton.getInstance(InscriptionActivity.this).postUser(user, new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        UserSingleton.getInstance().setUser(user);
                        Intent intent = new Intent(InscriptionActivity.this, FreakShowActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
