package com.tp1_techno_web.serietemporelle.model;

public class TimeSeries {
    private long id;
    private long user_id;
    private String tittle;
    private String description;

    public TimeSeries(long id, long user_id, String tittle, String description) {
        this.id = id;
        this.user_id = user_id;
        this.tittle = tittle;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
