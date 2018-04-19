package com.app.service;

import com.app.model.Factory;
import com.app.model.User;

import java.util.List;

public interface FactoryService {
    void add(Factory f);

    void update(Factory f);

    void delete(Factory f);

    List<Factory> findAll();

    boolean addUserToFactory(Long fId, User u);

    List<User> getAllUsersByFactory(String fId);

}
