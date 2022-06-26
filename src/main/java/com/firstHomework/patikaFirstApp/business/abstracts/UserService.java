package com.firstHomework.patikaFirstApp.business.abstracts;

import com.firstHomework.patikaFirstApp.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
}
