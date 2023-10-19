package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.Serie;
import com.tp1_techno_web.serietemporelle.repository.SerieEventRepository;
import com.tp1_techno_web.serietemporelle.service.SerieEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class SerieEventController {
    @Autowired
    private SerieEventService service;
    @GetMapping("/series")
    public List<Serie> getAllSeries(){
        return  service.getAllSeries();
    }
    @GetMapping("/series/{id}")
    public Serie getSerieById(@PathVariable  long id){
        return null;
    }

    @PostMapping("/series")
    @ResponseBody
    public List<Serie> createSerie(@RequestBody Serie serie){
        return this.service.createSerie(serie);
    }

    @PutMapping("/series/{id}")
    @ResponseBody
    public String updateSerie(@PathVariable long id, @RequestBody Serie serie){

        return "Updated with success";
    }

    @DeleteMapping("/{id}")
    public Serie deleteSerie(@PathVariable long id){

        return null;
    }
}
