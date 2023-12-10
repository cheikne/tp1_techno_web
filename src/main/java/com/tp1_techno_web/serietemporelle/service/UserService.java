package com.tp1_techno_web.serietemporelle.service;

import com.tp1_techno_web.serietemporelle.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private ArrayList<User> usersService = new ArrayList<>();
    public Object createUser(String username) {
        Map<String, String> status = new HashMap<>();
        var user = new User(username);
        if(!this.usersService.contains(user)) {
            this.usersService.add(user);
            status.put("message", "CREATED");
            return status;
        }
        status.put("message", "User already exist.");
        return status;
    }

    public boolean isExistUser(String username){
        if (username.isBlank()) return false;
        User user = new User(username);
        return usersService.contains(user);
    }

    public User getUserByUsername(String username) {
        Optional<User> user__ = this.usersService.stream()
                .filter(user -> username.equalsIgnoreCase(user.getusername())).findFirst();
        User myuser = user__.orElse(null);
        return myuser;
    }
}
