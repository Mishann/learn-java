package com.app.service;

import com.app.model.User;

import java.util.List;

public interface UserService {
    void add(User u);

    void update(User u);

    void delete(User u);

    List<User> findAll();
}
