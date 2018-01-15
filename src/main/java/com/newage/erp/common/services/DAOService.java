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
    protected GeneralDAO generalDAO;

    public List<T> find(Class<T> clazz) {
        return generalDAO.find(clazz);
    }

    public T find(Class<T> clazz, Long id) {
        return generalDAO.find(clazz, id);
    }

    public void persist(T entity) {
        generalDAO.persist(entity);
    }

    public void merge(T entity) {
        generalDAO.merge(entity);
    }

    public void remove(T entity) {
        generalDAO.remove(entity);
    }
}
