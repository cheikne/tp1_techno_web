package com.tp1_techno_web.serietemporelle.model;

public class UserSerie {


    private long id;
    private boolean isOwner;
    private User user;
    private TimeSeries timeSeries;
    private String  grant;

    public UserSerie(long id, boolean isOwner, User user, TimeSeries timeSeries, String grant) {
        this.id = id;
        this.isOwner = isOwner;
        this.user = user;
        this.timeSeries = timeSeries;
        this.grant = grant;
    }

    public long getId() {
        return id;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public User getUser() {
        return user;
    }

    public TimeSeries getTimeSeries() {
        return timeSeries;
    }

    public String getGrant() {
        return grant;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }
}
