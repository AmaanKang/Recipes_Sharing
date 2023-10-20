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
        User user = new User(payload.get("emailAddress"),payload.get("password"));
        if(userService.allUsers().contains(user)){
            return 1;
        }else{
            return payload.get("password").hashCode();
        }
    }
}
