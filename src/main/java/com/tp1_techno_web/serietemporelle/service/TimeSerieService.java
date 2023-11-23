package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TimeSerieService {
    private ArrayList<TimeSeries> timeSerieService = new ArrayList<>();

    public Object getAllTimeSeries(String header) {
        if(header.contains(MediaType.APPLICATION_JSON_VALUE)) {
            System.out.println("Header json detected ****************************");
            return this.timeSerieService;
        }
        if(header.contains(MediaType.TEXT_HTML_VALUE)) {
            System.out.println("Header Text html detected ****************************");
            return GenerateResponses.generateHtmlForTimeSeries(this.timeSerieService);
        }
        return this.timeSerieService;
    }


    public Object getTimeSeriesById(String header, long id) {

        return this.timeSerieService;
    }


    public Object createTimeSerie(TimeSeries timeSeries) {
        this.timeSerieService.add(timeSeries);

        return  this.timeSerieService;
    }

    public Object updateToTimeSerie(TimeSeries timeSeries, long id) {
        int i = 0;
        for (var timeS : this.timeSerieService){
            if(timeS.getId()==id) {
                //this.timeSerieService.remove(timeS);
//                this.timeSerieService.add(timeSeries);
                this.timeSerieService.set(i,timeSeries);
                break;
            }
            i = i+1;
        }

        return this.timeSerieService;
    }
}
