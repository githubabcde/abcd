package com.newage.erp.common.services;

import com.newage.erp.common.entities.SupperEntity;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class SupperCRUDService<T extends SupperEntity> {

    protected final Class<T> clazz;

    @Inject
    protected DAOService dao;

    public SupperCRUDService(Class clazz) {
        this.clazz = clazz;
    }

    public List<T> find() {
        return dao.find(clazz);
    }

    public T find(Long id) {
        return dao.find(clazz, id);
    }

    public void create(T entity) {
        dao.persist(entity);
    }

    public void update(T entity) {
        dao.merge(entity);
    }

    public void remove(T entity) {
        dao.remove(entity);
    }
}
