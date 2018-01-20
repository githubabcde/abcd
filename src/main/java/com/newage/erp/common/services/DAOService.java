package com.newage.erp.common.services;

import com.newage.erp.common.entities.EntityMaster;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class DAOService<T extends EntityMaster> {

    @Inject
    protected DataAccessObject dao;

    public List<T> find(Class<T> clazz) {
        return dao.find(clazz);
    }

    public T find(Class<T> clazz, Long id) {
        return dao.find(clazz, id);
    }

    public void persist(T entity) {
        dao.persist(entity);
    }

    public void merge(T entity) {
        dao.merge(entity);
    }

    public void remove(T entity) {
        dao.remove(entity);
    }
}
