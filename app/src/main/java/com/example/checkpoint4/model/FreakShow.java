package com.example.checkpoint4.model;

import java.util.HashSet;
import java.util.Set;

public class FreakShow {

    private Long id;

    private String name;

    private String description;

    private Set<User> users = new HashSet<>();

    public FreakShow() {
    }

    public FreakShow(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public FreakShow(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FreakShow(Long id, String name, String description, Set<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
