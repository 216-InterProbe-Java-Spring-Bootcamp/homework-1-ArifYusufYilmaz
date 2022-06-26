package com.firstHomework.patikaFirstApp.dao;

import com.firstHomework.patikaFirstApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
