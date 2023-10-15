package com.amandeep.Recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")

public class UserController {
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

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(userService.createUser(payload.get("emailAddress"),payload.get("password")), HttpStatus.CREATED);
    }
}
