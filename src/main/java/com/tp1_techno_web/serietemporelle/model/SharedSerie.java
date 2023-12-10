package com.tp1_techno_web.serietemporelle.model;

import com.tp1_techno_web.serietemporelle.service.IdGenerator;

public class SharedSerie {
    private long id;
    private long sharedSerieId;
    private Right permission;
    private User grantedUser;

    public SharedSerie(long sharedSerieId, Right permission, User grantedUser) {
        this.id = IdGenerator.nextId();
        this.sharedSerieId = sharedSerieId;
        this.permission = permission;
        this.grantedUser = grantedUser;
    }

    public long getId() {
        return id;
    }

    public Right getPermission() {
        return permission;
    }

    public User getGrantedUser() {
        return grantedUser;
    }

    public long getSharedSerieId() {
        return sharedSerieId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSharedSerieId(long sharedSerieId) {
        this.sharedSerieId = sharedSerieId;
    }

    public void setPermission(Right permission) {
        this.permission = permission;
    }

    public void setGrantedUser(User grantedUser) {
        this.grantedUser = grantedUser;
    }
}
