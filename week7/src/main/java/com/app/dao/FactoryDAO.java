package com.app.dao;

import com.app.model.Factory;

import java.util.List;

public interface FactoryDAO {
    void add(Factory u);

    void update(Factory u);

    void delete(Factory u);

    Factory finOne(Long id);

    List<Factory> findAll();
}
