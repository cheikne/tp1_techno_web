package com.tp1_techno_web.serietemporelle.model;

import java.util.ArrayList;
import java.util.List;

public class TimeSeries {
    private long id;
    private long user_id;
    private String title;
    private String description;

    private ArrayList<Event> events;


    public TimeSeries(long id, long user_id, String title, String description,ArrayList<Event> events) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.events = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Event> getEvents() {
        return this.events;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEvents(Event event) {
        this.events.add(event);
    }
}
