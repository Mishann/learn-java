package com.app.service;

import com.app.dao.FactoryDAO;
import com.app.dao.UserDAO;
import com.app.model.Factory;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    private FactoryDAO factoryDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void add(Factory f) {
        factoryDAO.add(f);
    }

    @Override
    public void update(Factory f) {
        factoryDAO.update(f);
    }

    @Override
    public void delete(Factory f) {
        factoryDAO.delete(f);
    }

    @Override
    public List<Factory> findAll() {
        return factoryDAO.findAll();
    }

    @Override
    public boolean addUserToFactory(Long fId, User u) {
        Factory factory = factoryDAO.finOne(fId);
        if (Objects.nonNull(factory)) {
            u.getFactories().add(factory);
            userDAO.add(u);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsersByFactory(String fId) {
        Factory factory = factoryDAO.finOne(Long.valueOf(fId));

        if (factory != null) {
            return userDAO.findAll()
                    .stream()
                    .filter(u -> u.getFactories().stream().anyMatch(f -> f.getId().equals(Long.valueOf(fId))))
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
}








