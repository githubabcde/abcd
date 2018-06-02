package com.newage.erp.common.services;

import com.newage.erp.common.entities.SupperEntity;
import java.util.List;
import javax.ejb.EJBAccessException;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class SupperCRUDService<T extends SupperEntity> {

    protected final Class<T> entityClass;

    @Inject
    protected DAOService dao;
    @Inject
    protected SecurityService ss;

    public SupperCRUDService(Class clazz) {
        this.entityClass = clazz;
    }

    public List<T> find() throws EJBAccessException {
        if (!ss.hasPermission(entityClass.getSimpleName() + ".desplay")) {
            throw new EJBAccessException();
        }
        return dao.find(entityClass);
    }

    public T find(Long id) throws EJBAccessException {
        if (!ss.hasPermission(entityClass.getSimpleName() + ".desplay")) {
            throw new EJBAccessException();
        }
        return dao.find(entityClass, id);
    }

    public void create(T entity) throws EJBAccessException {
        if (!ss.hasPermission(entityClass.getSimpleName() + ".create")) {
            throw new EJBAccessException();
        }
        dao.persist(entity);
    }

    public void update(T entity) throws EJBAccessException {
        if (!ss.hasPermission(entityClass.getSimpleName() + ".update")) {
            throw new EJBAccessException();
        }
        dao.merge(entity);
    }

    public void remove(T entity) throws EJBAccessException {
        if (!ss.hasPermission(entityClass.getSimpleName() + ".remove")) {
            throw new EJBAccessException();
        }
        dao.remove(entity);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}
