package com.newage.erp.common.services;

import com.newage.erp.common.entities.EntityMasterStamped;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class DAOService<T extends EntityMasterStamped> {

    @Inject
    protected GeneralDAO generalDAO;

    public List<T> find(Class<T> clazz) {
        return generalDAO.find(clazz);
    }

    public T find(Class<T> clazz, Long id) {
        return generalDAO.find(clazz, id);
    }

    public void persist(T entity, Long userId) {
        generalDAO.persist(entity, userId);
    }

    public void merge(T entity, Long userId) {
        generalDAO.merge(entity, userId);
    }

    public void remove(T entity, Long userId) {
        generalDAO.remove(entity, userId);
    }
}
