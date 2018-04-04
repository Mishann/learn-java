package com.app.service;

import com.app.dao.UserDAO;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void add(User u) {
        userDAO.add(u);
    }

    @Override
    public void update(User u) {

    }

    @Override
    public void delete(User u) {

    }

    @Override
    public List<User> findAll() {
       return userDAO.findAll();
    }
}
