package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import com.tp1_techno_web.serietemporelle.service.TimeSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimeSerieController {

//    @Autowired
//    TimeSerieService timeSerieServices;
//    @GetMapping("api/time_series")
//    public  Object getAllTimeSeries(@RequestHeader("Accept") String  header){
//        return timeSerieServices.getAllTimeSeries(header);
//    }
//    @GetMapping("api/time_series/{id}")
//    public  Object getAllTimeSeries(@RequestHeader("Accept") String  header, @PathVariable long id){
//        return timeSerieServices.getAllTimeSeries(header,id);
//    }
//    @PostMapping("api/time_series")
//    @ResponseBody
//    public  Object create(@RequestBody TimeSeries timeSeries){
//        return timeSerieServices.createTimeSerie(timeSeries);
//    }
//    @PutMapping("api/time_series/{id}")
//    @ResponseBody
//    public  Object udate(@RequestBody TimeSeries timeSeries, @PathVariable long id){
//        return timeSerieServices.updateToTimeSerie(timeSeries,id);
//    }

}