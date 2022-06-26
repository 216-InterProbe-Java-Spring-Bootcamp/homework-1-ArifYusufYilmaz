package com.firstHomework.patikaFirstApp.business.concretes;

import com.firstHomework.patikaFirstApp.business.abstracts.UserService;
import com.firstHomework.patikaFirstApp.dao.UserDao;
import com.firstHomework.patikaFirstApp.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    @Override
    public User createUser(User user) {
        return this.userDao.save(user);
    }
}
