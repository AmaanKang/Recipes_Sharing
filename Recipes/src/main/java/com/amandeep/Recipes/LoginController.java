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
        if(userService.allUsers().contains(new User(payload.get("emailAddress"),payload.get("password")))){
            return 1;
        }else{
            return 0;
        }
    }
}
