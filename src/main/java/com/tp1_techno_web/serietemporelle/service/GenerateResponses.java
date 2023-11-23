package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;

import java.util.ArrayList;

public class GenerateResponses {

    public GenerateResponses(){}

    public static String generateHtmlForEvent(Event event){
        return "<div>" +
                "<p>"+"Id of event "+event.getId()+"</p>"+
                "<p>"+"Value of event "+event.getValeur()+"</p>"+
                "<p>"+"Date of event"+event.getDate()+"</p>"+
                "<p>"+"Comment of event "+event.getCommentaire()+"</p>"+
                "</div>";
    }
    public  static String generateHtmlForEvents(ArrayList<Event> events){
        String html = "<div><h1>Information's events</h1>";
        for (Event event:events){
            html += generateHtmlForEvent((event));
            html +="<h1>Event num : "+event.getId()+"</h1>";
        }
        html += "</div>";
        return html;
    }

    public static Object generateHtmlForTimeSerie(TimeSeries timeSeries) {
        return "<div>" +
                "<p>"+"Id of event "+timeSeries.getId()+"</p>"+
                "<p>"+"Value of event "+timeSeries.getUser_id()+"</p>"+
                "<p>"+"Date of event"+timeSeries.getTitle()+"</p>"+
                "<p>"+"Comment of event "+timeSeries.getDescription()+"</p>"+
                "</div>";
    }
    public static Object generateHtmlForTimeSeries(ArrayList<TimeSeries> timeSerieService) {
        String html = "<div><h1>Information's Time serie</h1>";
        for (var time_serie:timeSerieService){
            html += generateHtmlForTimeSerie(time_serie);
            html +="<h1>Time serie  num : "+time_serie.getId()+"</h1>";
        }
        html += "</div>";
        return html;
    }
}
