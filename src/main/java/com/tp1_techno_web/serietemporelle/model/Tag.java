package com.tp1_techno_web.serietemporelle.model;

public class Tag {

    private long id;
    private String label;
    private Event event;

    public Tag(long id, String label, Event event) {
        this.id = id;
        this.label = label;
        this.event = event;
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
