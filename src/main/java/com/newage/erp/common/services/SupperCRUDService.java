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

    protected final Class<T> clazz;

    @Inject
    protected DAOService dao;
    @Inject
    protected SecurityService ss;

    public SupperCRUDService(Class clazz) {
        this.clazz = clazz;
    }

    public List<T> find() throws EJBAccessException {
        if (!ss.hasPermission(clazz.getSimpleName() + ".desplay")) {
            throw new EJBAccessException();
        }
        return dao.find(clazz);
    }

    public T find(Long id) throws EJBAccessException {
        if (!ss.hasPermission(clazz.getSimpleName() + ".desplay")) {
            throw new EJBAccessException();
        }
        return dao.find(clazz, id);
    }

    public void create(T entity) throws EJBAccessException {
        if (!ss.hasPermission(clazz.getSimpleName() + ".create")) {
            throw new EJBAccessException();
        }
        dao.persist(entity);
    }

    public void update(T entity) throws EJBAccessException {
        if (!ss.hasPermission(clazz.getSimpleName() + ".update")) {
            throw new EJBAccessException();
        }
        dao.merge(entity);
    }

    public void remove(T entity) throws EJBAccessException {
        if (!ss.hasPermission(clazz.getSimpleName() + ".remove")) {
            throw new EJBAccessException();
        }
        dao.remove(entity);
    }
}
