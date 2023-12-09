package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Event;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private ArrayList<Event> events = new ArrayList<>(List.of(
            new Event(1,new Date(),1,null,"Test commentaire 1"),
            new Event(2,new Date(),2,null,"Test commentaire 2"),
            new Event(3,new Date(),3,null,"Test commentaire 3"),
            new Event(4,new Date(),4,null,"Test commentaire 4"),
            new Event(5,new Date(),5,null,"Test commentaire 5")
    ));

    public Object getAllEvent(HttpServletRequest header){
        String headerAccept = header.getHeader("Accept");
        if(headerAccept.contains(MediaType.APPLICATION_JSON_VALUE)) {
            System.out.println("Header json detected ****************************");
            return this.events;
        }
        if(headerAccept.contains(MediaType.TEXT_HTML_VALUE)) {
            System.out.println("Header Text html detected ****************************");
            return GenerateResponses.generateHtmlForEvents(events);
        }
        return this.events;
    }
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

    public Map<String,String> deleteEvent(long id) {
        for (Event event:this.events){
            if (event.getId() == id){
                this.events.remove(event);
                break;
            };
        }

        Map<String, String> properties = new HashMap<>();
        properties.put("message", "Succès");

        return properties;
    }

    public ArrayList<Event> findAllEvent(){return  this.events;}

    public  Event findEventById(long id){
        for (Event event:this.events){
            if (event.getId() == id){
                return  event;
            };
        }
        return  null;
    }

    public  Event findEventValue(int value){
        for (Event event:this.events){
            if (event.getValue() == value){
                return  event;
            }
        }
        return  null;
    }
}
