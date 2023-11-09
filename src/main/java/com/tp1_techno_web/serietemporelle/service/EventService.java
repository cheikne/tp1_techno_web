package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    private ArrayList<Event> events = new ArrayList<>(List.of(
            new Event(1,new Date(),1,1,"Test commentaire 1"),
            new Event(2,new Date(),2,1,"Test commentaire 2"),
            new Event(3,new Date(),3,2,"Test commentaire 3"),
            new Event(4,new Date(),4,1,"Test commentaire 4"),
            new Event(5,new Date(),5,4,"Test commentaire 5")
    ));

    public List<Event> getAllEvent(){ return this.events;}
    public Event getEventById(long id){
        var event_searched = new Event();
        for (Event event:events){
            if (event.getId() == id){
                event_searched = event;
                break;
            }
        }
        return event_searched;
    }

    public List<Event> createEvents(Event event) {
        this.events.add(event);
        return this.events;
    }

    public List<Event> updateEvent(Event event_u, long id) {
        int i = 0;
        for (Event event:events){
            if (event.getId() == id){
               events.remove(event);
               events.add(event_u);
               break;
            }
            i += 1;
        }
        return  this.events;
    }
}
