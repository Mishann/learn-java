package com.app.dao;

import com.app.model.User;

import java.util.List;

public interface UserDAO {
    void add(User u);

    void update(User u);

    void delete(User u);

    List<User> findAll();
}
