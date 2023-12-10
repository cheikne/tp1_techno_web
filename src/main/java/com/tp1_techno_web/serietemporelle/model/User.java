package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {

    private long id;
    private String username;

    private final Pattern ALLOWED_USER = Pattern.compile("^[a-zA-Z ]{1,40}$");

    public User(String username) {
        if (username == null) throw new IllegalArgumentException();
        if (!ALLOWED_USER.matcher(username).matches()) throw new IllegalArgumentException();
        if (username.isBlank()) throw new IllegalArgumentException();
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

        return username.equalsIgnoreCase(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
