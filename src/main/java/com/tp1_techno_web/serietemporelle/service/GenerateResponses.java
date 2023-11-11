package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Event;

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
}
