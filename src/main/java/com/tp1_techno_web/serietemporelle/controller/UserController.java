package com.tp1_techno_web.serietemporelle.controller;

import com.tp1_techno_web.serietemporelle.model.User;
import com.tp1_techno_web.serietemporelle.model.UserSerie;
import com.tp1_techno_web.serietemporelle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService users;
    @PostMapping("/api/create_user")
    @ResponseBody
    public Object createUser(@RequestBody User user){

         return users.createUser(user);
    }



}
