package com.amandeep.Recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(String emailAddress, String password){
        User user = new User(emailAddress,password);

        userRepository.insert(user);
        return user;
    }
}
