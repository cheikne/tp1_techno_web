package com.tp1_techno_web.serietemporelle.model;

//import jakarta.persistence.*;

import java.util.Date;

//@Entity
//@Table(name = "testFirst")
public class Serie {


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String titre;
    private String description;

    public Serie(long id, String date, String titre, String description) {
        this.id = id;
        this.date = date;
        this.titre = titre;
        this.description = description;
    }
public Serie(){}
    public long getId() {
        return id;
    }

    public String getDate() {
        return this.date;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
