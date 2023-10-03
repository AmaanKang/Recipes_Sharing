package com.amandeep.Recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(userService.createUser(payload.get("emailAddress"),payload.get("password")), HttpStatus.CREATED);
    }
}
