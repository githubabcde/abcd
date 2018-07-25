package com.newage.erp.common.services;

import com.newage.erp.common.entities.SuperEntity;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author mohammed
 */
@Stateless
public class DataService {

    @PersistenceContext(unitName = "ERPPU")
    private EntityManager em;

    public void persist(SuperEntity e) {
        e.setId(getNewId(e.getClass()));
        em.persist(e);

    }

    public void merge(SuperEntity e) {
        em.merge(e);
    }

    public void remove(Object e) {
        em.remove(em.merge(e));
    }

    public <T> List<T> find(Class<T> entityClass) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public <T> T find(Class<T> entityClass, Long id) {
        return em.find(entityClass, id);
    }

    public <T> List<T> find(String namedQuery, Class<T> entityClass, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, entityClass);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public <T> T findOne(String namedQuery, Class<T> entityClass, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, entityClass);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Long getNewId(Class entityClass) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(entityClass);
        Root root = cq.from(entityClass);
        cq.select(cb.max(root.get("id")));
        TypedQuery q = em.createQuery(cq);
        Number maxId = ((Number) q.getSingleResult());
        return Objects.isNull(maxId) ? 1l : maxId.longValue() + 1l;
    }
}
