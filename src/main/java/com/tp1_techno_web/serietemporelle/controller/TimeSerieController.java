package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import com.tp1_techno_web.serietemporelle.service.TimeSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TimeSerieController {

    @Autowired
    private TimeSerieService timeSerieServices;
    @GetMapping("api/time_series")
    public  Object getAllTimeSeries(@RequestHeader("Accept") String  header){
        return timeSerieServices.getAllTimeSeries(header);
    }
    @GetMapping("api/time_series/{id}")
    public  Object getAllTimeSeries(@RequestHeader("Accept") String  header, @PathVariable long id){
        return timeSerieServices.getTimeSeriesById(header,id);
    }
    @PostMapping("api/time_series")
    @ResponseBody
    public  Object create(@RequestBody TimeSeries timeSeries){
        return timeSerieServices.createTimeSerie(timeSeries);
    }
    @PutMapping("api/time_series/{id}")
    @ResponseBody
    public  Object update(@RequestBody TimeSeries timeSeries, @PathVariable long id){
        return timeSerieServices.updateToTimeSerie(timeSeries,id);
    }

    @PostMapping("api/add_event_to_serie")
    @ResponseBody
    public Object addEventToSerie(@RequestBody Map<String,String> add_event_timeSerie){

        return this.timeSerieServices.addEventToSerie(add_event_timeSerie);
    }

}
