package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

public class Tag {

    private long id;
    private String label;
    private Event event;

    public Tag(String label) {
        this.id = IdGenerator.nextId();
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Event getEvent() {
        return event;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
