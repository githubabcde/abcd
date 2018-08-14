package com.newage.erp.common.services;

import com.newage.erp.common.entities.SuperEntity;
import java.util.List;
import javax.ejb.EJBAccessException;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class SuperCRUDService<T extends SuperEntity> {

    protected final Class<T> entityClass;

    @Inject
    protected DataService dataService;
    @Inject
    protected SecurityService securityService;

    public SuperCRUDService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> find() {
        if (!securityService.hasPermission(entityClass.getSimpleName() + ".desplay")) {
            throw new EJBAccessException();
        }
        return dataService.find(entityClass);
    }

    public T find(Long id) {
        if (!securityService.hasPermission(entityClass.getSimpleName() + ".desplay")) {
            throw new EJBAccessException();
        }
        return dataService.find(entityClass, id);
    }

    public void create(T entity) {
        if (!securityService.hasPermission(entityClass.getSimpleName() + ".create")) {
            throw new EJBAccessException();
        }
        dataService.persist(entity);
    }

    public void update(T entity) {
        if (!securityService.hasPermission(entityClass.getSimpleName() + ".update")) {
            throw new EJBAccessException();
        }
        dataService.merge(entity);
    }

    public void remove(T entity) {
        if (!securityService.hasPermission(entityClass.getSimpleName() + ".remove")) {
            throw new EJBAccessException();
        }
        dataService.remove(entity);
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}
