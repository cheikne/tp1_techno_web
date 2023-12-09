package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
            return this.getAllTimeSeriesForOwner(username);
        }
        if(accept.contains(MediaType.TEXT_HTML_VALUE)) {
            System.out.println("Header Text html detected ****************************");
            return GenerateResponses.generateHtmlForTimeSeries(this.timeSerieService);
        }
        return this.getAllTimeSeriesForOwner(username);
    }


    public Object getTimeSeriesById(HttpServletRequest headers, long id) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist.");
        return this.getOneTimeSeriesForOwner(username,id);
    }


    public Object createTimeSerie(TimeSeries timeSeries,HttpServletRequest headers) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist. You have to create first "+username);
        timeSeries.setOwner(username);
        this.timeSerieService.add(timeSeries);

        return  this.getAllTimeSeriesForOwner(username);
    }

    public Object updateToTimeSerie(TimeSeries timeSeries, HttpServletRequest headers,long id) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist."+username.toUpperCase()+"  can't edit");
        int i = 0;
        for (var timeS : this.timeSerieService){
            if(timeS.getId()==id && timeS.getOwner().toUpperCase().equals(username.toUpperCase())) {
                this.timeSerieService.set(i,timeSeries);
                return timeSeries;
            }
            i = i+1;
        }

        return this.messageError("Your time serie does not exist!");
    }

    public Object addEventToSerie(ArrayList<Event>  allEvents, long id,HttpServletRequest headers) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist.");

        if(allEvents == null || allEvents.isEmpty())
            return messageError("Can't add event null in time serie");
        int i=0;
        for (var timeS:this.timeSerieService) {
            if (timeS.getId() == id && timeS.getOwner().equalsIgnoreCase(username)) {
                for(var eachEvent: allEvents){
                    if (!timeS.getEvents().contains(eachEvent))
                        timeS.addEvents(eachEvent);
                }
                this.timeSerieService.set(i, timeS);
                return timeS;
            }
            i = i + 1;
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

    private Object getAllTimeSeriesForOwner(String username){
        return this.timeSerieService.stream()
                .filter(obj -> username.toUpperCase().equals(obj.getOwner().toUpperCase()))
                .collect(Collectors.toList());
    }
    private Object getOneTimeSeriesForOwner(String username,long id){
        return this.timeSerieService.stream()
                .filter(obj -> username.toUpperCase().equals(obj.getOwner().toUpperCase()) && obj.getId()==id)
                .findFirst();
    }
}

