package com.newage.erp.common.services;

import com.newage.erp.common.entities.SuperEntity;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class SuperCRUDService<T extends SuperEntity> {

    protected final Class<T> entityClass;

    @Inject
    protected DAOService dao;
    @Inject
    protected SecurityService ss;

    public SuperCRUDService(Class entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> find() {
        ss.applyPermission(entityClass.getSimpleName() + ".desplay");
        return dao.find(entityClass);
    }

    public T find(Long id) {
        ss.applyPermission(entityClass.getSimpleName() + ".desplay");
        return dao.find(entityClass, id);
    }

    public void create(T entity) {
        ss.applyPermission(entityClass.getSimpleName() + ".create");
        dao.persist(entity);
    }

    public void update(T entity) {
        ss.applyPermission(entityClass.getSimpleName() + ".update");
        dao.merge(entity);
    }

    public void remove(T entity) {
        ss.applyPermission(entityClass.getSimpleName() + ".remove");
        dao.remove(entity);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}
