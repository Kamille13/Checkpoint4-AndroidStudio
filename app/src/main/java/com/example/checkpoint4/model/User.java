package com.example.checkpoint4.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;

    private String email;

    private String password;

    private Set<FreakShow> freakshows = new HashSet<>();

    public User() {
    }

    public User(Long id, String email, String password, Set<FreakShow> freakshows) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.freakshows = freakshows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<FreakShow> getFreakshows() {
        return freakshows;
    }

    public void setFreakshows(Set<FreakShow> freakshows) {
        this.freakshows = freakshows;
    }
}
