package com.example.checkpoint4;

import com.example.checkpoint4.model.User;

public class UserSingleton {

    private static UserSingleton instance;
    private User user;

    private UserSingleton() {
    }

    public static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
