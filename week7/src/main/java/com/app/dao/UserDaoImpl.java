package com.app.dao;

import com.app.model.User;
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
        manager.merge(u);
    }

    @Override
    public void delete(User u) {
        manager.remove(u);
    }

    @Override
    public User findOne(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        String hql = "From User";
        return (List<User>) manager.createQuery(hql).getResultList();
    }
}
