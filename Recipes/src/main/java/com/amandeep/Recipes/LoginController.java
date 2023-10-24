package com.amandeep.Recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/login")

public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public int loginUser(@RequestBody Map<String,String> payload){
        if(userService.allUsers()
                .stream()
                .anyMatch(u -> u.getEmailAddress().equals(payload.get("emailAddress")) && u.getPassword() == payload.get("password").hashCode())){
            return 1;
        }else{
            return payload.get("password").hashCode();
        }
    }
}
