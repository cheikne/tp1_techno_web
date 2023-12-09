package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

import java.util.ArrayList;

public class User {

    private long id;
    private String username;


    public User(long id, String username) {
        this.id = IdGenerator.nextId();
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setusername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
