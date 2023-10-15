package com.amandeep.Recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }


    public User createUser(String emailAddress, String password){
        User user = new User(emailAddress,password);
        userRepository.insert(user);
        return user;
    }
}
