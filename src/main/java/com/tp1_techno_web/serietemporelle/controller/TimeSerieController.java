package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import com.tp1_techno_web.serietemporelle.service.TimeSerieService;
import com.tp1_techno_web.serietemporelle.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeSerieController {

    @Autowired
    private TimeSerieService timeSerieServices;

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
    public  Object update(@RequestBody TimeSeries timeSeries,HttpServletRequest headers, @PathVariable long id){
        return timeSerieServices.updateToTimeSerie(timeSeries,headers,id);
    }

    @PostMapping("api/add_event/{id}")
    @ResponseBody
    public Object addEventToSerie(@RequestBody ArrayList<Event> allEvents,@PathVariable long id,HttpServletRequest headers){

        return this.timeSerieServices.addEventToSerie(allEvents,id,headers);
    }

}
