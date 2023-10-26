package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.repository.EventRepository;
import com.tp1_techno_web.serietemporelle.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService service;
    @GetMapping("/api/events")
    public List<Event> getAllEvent(){
        return service.getAllEvent();
    }
}
