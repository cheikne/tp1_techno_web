package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Event;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class GenerateResponses {

    public GenerateResponses(){}

    public static String generateHtmlForEvent(Event event){
        return "<tr>\n"+
                "<td>"+event.getId()+"</td>\n"+
                "<td>"+event.getDate()+"</td>\n"+
                "<td>"+event.getValue()+"</td>\n"+
                "<td>"+event.getCreatedAt()+"</td>\n"+
                "<td>"+event.getUpdatedAt()+"</td>\n"+
                "<td>"+event.getTags()+"</td>\n"+
                "<td>"+event.getComment()+"</td>\n"+
                "</tr>\n" ;
    }
    public  static String generateHtmlForEvents(ArrayList<Event> events){
        String html = "<table>\n" +
                "            <thead>\n" +
                "              <tr>\"+\n" +
                "                <th>Id</th>\n" +
                "                <th>Date</th>\n" +
                "                <th>Valeur</th>\n" +
                "                <th>Date</th>\n" +
                "                <th>Date mis à jour</th>\n" +
                "                <th>Tags</th>\n" +
                "                <th>Commentaire</th>\n" +
                "              </tr>\n" +
                "            </thead>\n" +
                "            <tbody>";
        for (Event event:events){
            html += generateHtmlForEvent((event));
        }
        html += "</tbody>\n"+
                "</table>";
        return html;
    }

    public static Object generateHtmlForTimeSerie(TimeSeries timeSeries) {
        return "<div>\n"+
                "<table style='width: 80%; margin: 20px'>\n"+
                "<thead>\n"+
                "<tr>\n"+
                "<th colspan='9'>Times Série</th>\n"+
                "</tr>\n"+
                "</thead>\n"+
                "<tbody>\n"+
                "<tr>\n"+
                "<td>Id</td>\n"+
                "<td colspan='8'>"+timeSeries.getId()+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>Auteur</td>\n"+
                "<td colspan='8'>"+timeSeries.getOwner()+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>Titre</td>\n"+
                "<td colspan='8'>"+timeSeries.getTitle() +"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>Description</td>\n"+
                "<td colspan='8'>"+timeSeries.getDescription()+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>Date</td>\n"+
                "<td colspan='8'>"+timeSeries.getCreatedAt()+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>Date mis à jour</td>\n"+
                "<td colspan='8'>"+timeSeries.getUpdatedAt()+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td rowspan>Evenements</td>\n"+
                "<td>"+generateHtmlForEvents((ArrayList<Event>) timeSeries.getEvents())+"</td>\n"+
                "</tr>\n"+
                "</tbody>\n"+
                "</table>\n"+
                "</div>";
    }
    public static Object generateHtmlForTimeSeries(ArrayList<TimeSeries> timeSerieService) {
        String html = "<div>\n" +
                "  <style>\n" +
                "    table {\n" +
                "      border-collapse: collapse;\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    th,\n" +
                "    td {\n" +
                "      border: 1px solid black;\n" +
                "      padding: 8px;\n" +
                "      text-align: left;\n" +
                "    }\n" +
                "  </style>\n" +
                "<div>\n"+
                "<h1>Information's Time serie</h1>";
        for (var time_serie:timeSerieService){
            html +="<h1>Time serie  num : "+time_serie.getId()+"</h1>";
            html += generateHtmlForTimeSerie(time_serie);
        }
        html += "</div>";
        return html;
    }
}