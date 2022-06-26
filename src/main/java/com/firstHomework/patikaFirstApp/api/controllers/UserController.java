package com.firstHomework.patikaFirstApp.api.controllers;

import com.firstHomework.patikaFirstApp.business.abstracts.UserService;
import com.firstHomework.patikaFirstApp.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createOneUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

}
