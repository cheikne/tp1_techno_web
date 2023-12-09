package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private   ArrayList<User> usersService = new ArrayList<>();
    public Object createUser(User user) {
        this.usersService.add(user);
        Map<String,String> status = new HashMap<>();
        status.put("message","CREATED");
        return status;
    }

    public  boolean isExistUser(String username){
        User user = new User(username);
        return usersService.contains(user);
    }
}
