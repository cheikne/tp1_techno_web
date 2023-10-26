package com.tp1_techno_web.serietemporelle.model;

//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

import java.util.Date;

//@Table
public class Event {

//    @Id
    private long id;
    private Date date;

    private int valeur;
    private int tag;
    private String commentaire;


    public Event(long id, Date date, int valeur, int tag, String commentaire) {
        this.id = id;
        this.date = date;
        this.valeur = valeur;
        this.tag = tag;
        this.commentaire = commentaire;
    }
    public Event(){}

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getValeur() {
        return valeur;
    }

    public int getTag() {
        return tag;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
