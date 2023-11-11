package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.repository.EventRepository;
import com.tp1_techno_web.serietemporelle.service.EventService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EventController {

    @Autowired
    private EventService service;
    @GetMapping("/api/events")
    public Object getAllEvent(HttpServletRequest header){
        return service.getAllEvent(header);
    }
    @GetMapping("/api/events/{id}")
    public Event getEventById(@PathVariable long id){
        return service.getEventById(id);
    }

    @PostMapping("/api/events")
    @ResponseBody
    public List<Event> createEvents(@RequestBody Event event){
        return service.createEvents(event);
    }

    @PutMapping("/api/events/{id}")
    @ResponseBody
    public List<Event> updateEvent(@RequestBody Event event, @PathVariable long id){
        return service.updateEvent(event,id);
    }

    @DeleteMapping("/api/events/{id}")
    public Map<String,String> deleteEvent(@PathVariable long id){
        return service.deleteEvent(id);
    }
}
