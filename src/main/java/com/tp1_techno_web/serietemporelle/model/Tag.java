package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

import java.util.regex.Pattern;

public class Tag {

    private long id;
    private String label;


    private final Pattern ALLOWED_TAG = Pattern.compile("^[a-zA-Z0-9_ ]{1,40}$");

    public Tag(String label) {
        if (label == null) throw new IllegalArgumentException();
        if (!ALLOWED_TAG.matcher(label).matches()) throw new IllegalArgumentException();
        if (label.isBlank()) throw new IllegalArgumentException();
        this.id = IdGenerator.nextId();
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return label;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String label) {
        this.label = label;
    }

}
