package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class TimeSerieService {
    private ArrayList<TimeSeries> timeSerieService = new ArrayList<>();
    @Autowired
    private EventService event;
    @Autowired
    private UserService usersService;
    public Object getAllTimeSeries(HttpServletRequest headers) {
        String accept = headers.getHeader("Accept");
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist.");
        System.out.println("Header username **************************** "+accept);
        if(accept.contains(MediaType.APPLICATION_JSON_VALUE)) {
            System.out.println("Header json detected ****************************");
            return this.timeSerieService;
        }
        if(accept.contains(MediaType.TEXT_HTML_VALUE)) {
            System.out.println("Header Text html detected ****************************");
            return GenerateResponses.generateHtmlForTimeSeries(this.timeSerieService);
        }
        return this.timeSerieService;
    }


    public Object getTimeSeriesById(HttpServletRequest headers, long id) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist.");
        return this.timeSerieService;
    }


    public Object createTimeSerie(TimeSeries timeSeries,HttpServletRequest headers) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist. You have to create first "+username);
        timeSeries.setOwner(username);
        this.timeSerieService.add(timeSeries);

        return  this.timeSerieService;
    }

    public Object updateToTimeSerie(TimeSeries timeSeries, HttpServletRequest headers,long id) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist."+username.toUpperCase()+"  can't edit");
        int i = 0;
        for (var timeS : this.timeSerieService){
            if(timeS.getId()==id) {
                this.timeSerieService.set(i,timeSeries);
                break;
            }
            i = i+1;
        }

        return this.timeSerieService;
    }

    public Object addEventToSerie(Map<String,String> add_event_timeSerie) {
        Integer integer_event=null;
        Integer integer_time_serie=null;
        boolean isString_time_serie = false;
        if(isInteger(add_event_timeSerie.get("event")))
            integer_event = Integer.valueOf(add_event_timeSerie.get("event"));
        var event_to_add = this.event.findEventById(integer_event);
        if(event_to_add == null)
            return  this.messageError("Your Event does not exist.");
        if(isInteger(add_event_timeSerie.get("time_serie"))){
            integer_time_serie = Integer.valueOf(add_event_timeSerie.get("time_serie"));
            isString_time_serie = true;
        }
        int i=0;
        for (var timeS:this.timeSerieService){
            if(!isString_time_serie && timeS.getTitle().toLowerCase().equals(add_event_timeSerie.get("time_serie").toLowerCase())){
                if(timeS.getEvents().contains(event_to_add))
                    return  this.messageError("Event already  exist.");
                timeS.setEvents(event_to_add);
                this.timeSerieService.set(i,timeS);
                return timeS;
            }else if(isString_time_serie && timeS.getId() == integer_time_serie){
                if(timeS.getEvents().contains(event_to_add))
                    return  this.messageError("Event already  exist.");
                timeS.setEvents(event_to_add);
                this.timeSerieService.set(i,timeS);
                return timeS;
            }
            i = i+1;
        }

        return  this.messageError("Your Time serie does not exist.");
    }

    private boolean isInteger(String str){
        try {
            Integer integer_event = Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public Map<String ,String> messageError(String message){
        Map<String,String> notExist = new HashMap<>();
        notExist.put("messageError",message);
        return notExist;
    }
}
