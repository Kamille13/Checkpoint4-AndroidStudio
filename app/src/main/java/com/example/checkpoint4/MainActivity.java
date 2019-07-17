package com.example.checkpoint4;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.checkpoint4.model.FreakShow;
import com.example.checkpoint4.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSignIn = findViewById(R.id.btInscription);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassWord);
        Button btConnexion = findViewById(R.id.btConnexion);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });

        btConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Erreur")
                            .setMessage("Veuillez renseigner votre email et mot de passe")
                            .show();
                }
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);

                VolleySingleton.getInstance(MainActivity.this)
                        .signIn(user, new Consumer<User>() {
                            @Override
                            public void accept(User user) {
                                UserSingleton.getInstance().setUser(user);
                                if(user != null) {
                                    Intent intent = new Intent(MainActivity.this,
                                            FreakShowActivity.class);
                                    startActivity(intent);
                                }
                            }

                        });
            }
        });
    }
}

