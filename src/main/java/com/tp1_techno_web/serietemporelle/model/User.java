package com.tp1_techno_web.serietemporelle.model;

import java.util.ArrayList;

public class User {

    private long id;
    private String userName;
    private ArrayList<TimeSeries> series;


    public User(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<TimeSeries> getSeries() {
        return series;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSeries(ArrayList<TimeSeries> series) {
        this.series = series;
    }
}
