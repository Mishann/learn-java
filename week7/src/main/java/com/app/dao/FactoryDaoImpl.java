package com.app.dao;

import com.app.model.Factory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FactoryDaoImpl implements FactoryDAO {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(Factory u) {
        manager.persist(u);
    }

    @Override
    public void update(Factory u) {
        manager.merge(u);
    }

    @Override
    public void delete(Factory u) {
        manager.remove(u);
    }

    @Override
    public Factory finOne(Long id) {
        return manager.find(Factory.class, id);
    }

    @Override
    public List<Factory> findAll() {

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Factory> cq = cb.createQuery(Factory.class);
        Root<Factory> rootEntry = cq.from(Factory.class);
        CriteriaQuery<Factory> all = cq.select(rootEntry);
        TypedQuery<Factory> allQuery = manager.createQuery(all);

        return allQuery.getResultList();
    }
}
