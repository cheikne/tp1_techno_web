package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.model.Tag;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import com.tp1_techno_web.serietemporelle.service.SharedSerieService;
import com.tp1_techno_web.serietemporelle.service.TimeSerieService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TimeSerieController {

    @Autowired
    private TimeSerieService timeSerieServices;
    @Autowired
    private SharedSerieService sharedSerieService;
    @GetMapping("api/time_series")
    public  Object getAllTimeSeries(HttpServletRequest headers){
        return timeSerieServices.getAllTimeSeries(headers);
    }
    @GetMapping("api/time_series/{id}")
    public  Object getAllTimeSeries(HttpServletRequest headers, @PathVariable long id){
        return timeSerieServices.getTimeSeriesById(headers,id);
    }
    @PostMapping("api/time_series")
    @ResponseBody
    public  Object create(@RequestBody TimeSeries timeSeries,HttpServletRequest headers){

        return timeSerieServices.createTimeSerie(timeSeries,headers);
    }
    @PutMapping("api/time_series/{id}")
    @ResponseBody
    public  Object updateTimeSerieTitle(@RequestBody ChangeTitle newTitle, HttpServletRequest headers, @PathVariable long id){
        return timeSerieServices.updateTimeSerie(newTitle.title,newTitle.description,headers,id);
    }

    @PutMapping("api/time_series/{id}/events/{eventId}")
    @ResponseBody
    public  Object updateTimeSerieEvent(@RequestBody Event newEvent, HttpServletRequest headers, @PathVariable long id,
                                        @PathVariable long eventId){
        return timeSerieServices.updateTimeSerieEvent(newEvent, headers,id, eventId);
    }

    @PostMapping("api/add_event/{id}")
    @ResponseBody
    public Object addEventToSerie(@RequestBody ArrayList<Event> allEvents,@PathVariable long id,HttpServletRequest headers){

        return this.timeSerieServices.addEventToSerie(allEvents,id,headers);
    }

    @DeleteMapping("api/time_series/{id}/events/{eventId}")
    public Object deleteEventFromSerie(@PathVariable long id, @PathVariable long eventId,HttpServletRequest headers){
        return this.timeSerieServices.deleteTimeSerieEvent(eventId,id,headers);
    }
    @DeleteMapping("api/time_series/{id}")
    public Object deleteTimeSerieById(@PathVariable long id,HttpServletRequest headers){
        this.sharedSerieService.removeSharedSerie(id);
        return this.timeSerieServices.deleteTimeSerieById(id,headers);
    }

    @PostMapping("api/tags")
    @ResponseBody
    public Object addTagToEvent(@RequestBody MyTags tag,HttpServletRequest headers){
        return this.timeSerieServices.addTagToEvent(tag,headers);
    }
    @Data
    public static class ChangeTitle {
        private String title;
        private String description;
    }
    @Data
    public static class MyTags {
        private String name;
        private long event_id;
        private long serie_id;

        public long getSerieId() {
            return this.serie_id;
        }
        public long getEventId() {
            return this.event_id;
        }
        public String getName() {
            return this.name;
        }
    }

}
