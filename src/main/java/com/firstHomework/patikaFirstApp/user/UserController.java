package com.firstHomework.patikaFirstApp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class  UserController {
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
