package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//@Table
public class Event {

    //    @Id
    private long id;
    private Date date;

    private double value;
    private ArrayList<Tag> tags;
    private String comment;
    private Date createdAt;
    private Date updatedAt;

    public Event(Date date, double value) {
        this.id = IdGenerator.nextId();
        if (date == null) throw new IllegalArgumentException();
        this.date = date;
        this.value = value;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Event(Date date, double value, String comment, Tag ... tags) {
        this(date, value);
        this.tags = new ArrayList<Tag>(Arrays.asList(tags));
        this.comment = comment;
    }


    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public String getComment() {
        return comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setTags(ArrayList<Tag> tag) {
        this.tags = tag;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}