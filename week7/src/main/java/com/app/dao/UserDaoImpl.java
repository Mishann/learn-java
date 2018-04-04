package com.app.dao;

import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User u) {
        manager.persist(u);
    }

    @Override
    public void update(User u) {

    }

    @Override
    public void delete(User u) {

    }

    @Override
    public List<User> findAll() {
        String hql = "From User";
        return (List<User>) manager.createQuery(hql).getResultList();
    }
}
