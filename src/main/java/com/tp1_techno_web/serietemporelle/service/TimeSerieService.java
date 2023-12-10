package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.controller.TimeSerieController;
import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.model.Tag;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TimeSerieService {
    private ArrayList<TimeSeries> timeSerieService = new ArrayList<>();
    private ArrayList<Tag> tags = new ArrayList<>();
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
        System.out.println("****************************************");
        this.timeSerieService.add(timeSeries);

        return  this.getAllTimeSeriesForOwner(username);
    }

    public Object updateTimeSerie(String newTitle, String newDescription, HttpServletRequest headers, long id) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist."+username.toUpperCase()+"  can't edit");
        int i = 0;
        for (var timeS : this.timeSerieService){
            if(timeS.getId()==id && timeS.getOwner().equalsIgnoreCase(username)) {
                if (newTitle != null) this.timeSerieService.get(i).setTitle(newTitle);
                if (newDescription != null) this.timeSerieService.get(i).setDescription(newDescription);
                return getOneTimeSeriesForOwner(username, id);
            }
            i = i+1;
        }

        return this.messageError("Your time serie does not exist!");
    }

    public Object updateTimeSerieEvent(Event newEvent, HttpServletRequest headers, long id, long eventId) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist."+username.toUpperCase()+"  can't edit");
        int i = 0;
        for (var timeS : this.timeSerieService){
            if(timeS.getId()==id && timeS.getOwner().equalsIgnoreCase(username)) {
                if (newEvent != null) {
                    newEvent.setId(eventId);
                    this.timeSerieService.get(i).setEventById(newEvent);
                }
                return getOneTimeSeriesForOwner(username, id);
            }
            i = i+1;
        }

        return this.messageError("Your time serie does not exist!");
    }

    public Object deleteTimeSerieEvent(long eventId, long id, HttpServletRequest headers) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist."+username.toUpperCase()+"  can't edit");
        int i = 0;
        for (var timeS : this.timeSerieService){
            if(timeS.getId()==id && timeS.getOwner().equalsIgnoreCase(username)) {
                this.timeSerieService.get(i).deleteEventById(eventId);
                return getOneTimeSeriesForOwner(username, id);
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
                .filter(obj -> username.equalsIgnoreCase(obj.getOwner()))
                .collect(Collectors.toList());
    }
    private Object getOneTimeSeriesForOwner(String username,long id){
        return this.timeSerieService.stream()
                .filter(obj -> username.equalsIgnoreCase(obj.getOwner()) && obj.getId()==id)
                .findFirst();
    }

    public TimeSeries findOneByIdSerie(long id){
        Optional<TimeSeries> searchedSerie = this.timeSerieService.stream()
                .filter(obj -> obj.getId()==id)
                .findFirst();
        TimeSeries myserie = searchedSerie.orElse(null);
        return myserie;
    }

    public Object deleteTimeSerieById(long id, HttpServletRequest headers) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist.");
        var isFind = false;
        for (var timeS:this.timeSerieService){
            if(timeS.getOwner().equalsIgnoreCase((username)) && timeS.getId() == id){
                this.timeSerieService.remove(timeS);
                isFind = true;
                break;
            }
        }
        if(isFind)
            return getAllTimeSeriesForOwner(username);
        return messageError("Your username or time serie does nit exist.");
    }

    public Object addTagToEvent(TimeSerieController.MyTags tag, @NotNull HttpServletRequest headers) {
        String username = headers.getHeader("username");
        if(!usersService.isExistUser(username))
            return messageError("User "+username+" does not exist.");
        int i = 0;
        var isFind = false;
        for (var timeS:this.timeSerieService){
            if(timeS.getId() == tag.getSerieId()){
                int j = 0;
                for (var event:timeS.getEvents()){
                    if (event.getId() == tag.getEventId()){
                        var newTag = new Tag(tag.getName());
                        this.tags.add(newTag);
                        this.timeSerieService.get(i).getEvents().get(j).getTags().add(newTag);
                        isFind = true;
                        break;
                    }
                    j++;
                }
            }
            i++;
            if(isFind)  break;
        }
        return getOneTimeSeriesForOwner(username,tag.getSerieId());
    }
}

