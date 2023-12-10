package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.service.SharedSerieService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShardedSerieController {

    @Autowired
    private SharedSerieService sharedSerie;
    @PostMapping("api/share_serie")
    public Object ShareTimeSerie(@RequestBody MyJsonData data, HttpServletRequest headers){
        return this.sharedSerie.createShareSerie(data.username,data.serie_id,data.isEditor,headers);
    }

    @PostMapping("api/change_right")
    public Object ShareTimeSerie(@RequestBody ChangeRight data, HttpServletRequest headers){
        return this.sharedSerie.changeRight(data.id,data.isEditor,headers);
    }

    @GetMapping("api/my_shares")
    public Object getMyShares(HttpServletRequest headers){
        return this.sharedSerie.getMySharedSerie(headers);
    }
    @Data
    public static class MyJsonData {
        private String username;
        private long serie_id;
        private int isEditor;
    }
    @Data
    public static class ChangeRight {
        private long id;
        private int isEditor;
    }
}
