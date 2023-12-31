package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TimeSeries {
    private long id;
    private String owner;
    private String title;
    private String description;

    private ArrayList<Event> events;
    private Date createdAt;
    private Date updatedAt;



    public TimeSeries(String title, String description, ArrayList<Event> events) {
        this.id = IdGenerator.nextId();
        this.title = title;
        this.description = description;
        if(events == null)
            this.events = new ArrayList<>();
        else this.addEventsToTimeSerie(events);
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
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
    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addEvents(Event event) {
        this.events.add(event);
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setEventById(Event event) {
        var i = 0;
        for (var e: this.events) {
            if (e.getId() == event.getId())
            {
                event.setCreatedAt(e.getCreatedAt());
                event.setUpdatedAt(new Date());
                this.events.set(i, event);
            }
            i++;
        }
    }

    public void deleteEventById(long id) {
        var i = 0;
        for (var e: this.events) {
            if (e.getId() == id)
            {
                this.events.remove(i);
            }
            i++;
        }
    }

    private void addEventsToTimeSerie(ArrayList<Event> events){
        this.events = new ArrayList<Event>();
        events.forEach(obj->this.addEvents(obj));
    }

}
