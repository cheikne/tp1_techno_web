package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.Right;
import com.tp1_techno_web.serietemporelle.model.SharedSerie;
import com.tp1_techno_web.serietemporelle.model.TimeSeries;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class SharedSerieService {


    ArrayList<SharedSerie> sharedSerieService = new ArrayList<>();

    @Autowired
    private UserService userService;

    @Autowired
    private TimeSerieService timeSerieService;

    public Object createShareSerie(String username, long serieId, boolean isEditor, HttpServletRequest headers) {
        String username_owner = headers.getHeader("username");
        if(!userService.isExistUser(username_owner))
            return messageError("You can't do this action because you're don't not exist.");
        if(!userService.isExistUser(username))
            return messageError("User "+username+" does not exist. You can't share time serie with user does not exist");
        if(this.isAllReadyShared(username,serieId))
            return messageError("This serie is already shared with user "+username);
        TimeSeries serie =  this.timeSerieService.findOneByIdSerie(serieId);
        if(serie == null) return  messageError("Your Time Serrie does not exist.");
        if(!serie.getOwner().equalsIgnoreCase(username_owner))
            return messageError("You're not owner on this time serie.");
        var newShared = new SharedSerie(serieId,isEditor ? Right.EDITOR:Right.READER,this.userService.getUserByUsername(username));
        this.sharedSerieService.add(newShared);

        return this.sharedSerieService;
        //return this.messageSucces("Your time serie is shared with sucess with "+username);

    }

    public Map<String ,String> messageError(String message){
        Map<String,String> notExist = new HashMap<>();
        notExist.put("messageError",message);
        return notExist;
    }

    public Map<String ,String> messageSucces(String message){
        Map<String,String> notExist = new HashMap<>();
        notExist.put("messageSucces",message);
        return notExist;
    }

    public boolean isAllReadyShared(String username,long serie_id){
       for(var each:this.sharedSerieService){
           if(each.getGrantedUser().getusername().equalsIgnoreCase(username) && each.getSharedSerieId()==serie_id){
               return true;
           }
       }
       return false;
    }
}
