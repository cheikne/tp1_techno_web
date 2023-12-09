package com.tp1_techno_web.serietemporelle.model;

import java.util.ArrayList;
import java.util.Date;

//@Table
public class Event {

    //    @Id
    private long id;
    private Date date;

    private double value;
    private ArrayList<Tag> tag;
    private String comment;
    private Date createdAt;
    private Date updatedAt;

    public Event(long id, Date date, double value, ArrayList<Tag> tag, String comment) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.tag = tag;
        this.comment = comment;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Event(long id, Date date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Event(){}

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public ArrayList<Tag> getTag() {
        return tag;
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

    public void setTag(ArrayList<Tag> tag) {
        this.tag = tag;
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