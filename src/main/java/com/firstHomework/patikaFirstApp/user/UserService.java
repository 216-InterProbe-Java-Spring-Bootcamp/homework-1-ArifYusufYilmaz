package com.firstHomework.patikaFirstApp.user;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
}
