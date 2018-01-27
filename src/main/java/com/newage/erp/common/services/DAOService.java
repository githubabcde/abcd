package com.newage.erp.common.services;

import com.newage.erp.common.entities.SupperEntity;
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
public class DAOService {

    @PersistenceContext(unitName = "erpPU")
    private EntityManager em;

    public void persist(SupperEntity e) {
        e.setId(getNewId(e.getClass()));
        em.persist(e);

    }

    public void merge(SupperEntity e) {
        em.merge(e);
    }

    public void remove(Object e) {
        em.remove(em.merge(e));
    }

    public <T> List<T> find(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public <T> T find(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    public <T> List<T> find(String namedQuery, Class<T> clazz, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, clazz);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    public <T> T findOne(String namedQuery, Class<T> clazz, Object... params) {
        try {
            TypedQuery<T> typedQuery = em.createNamedQuery(namedQuery, clazz);
            for (int i = 0; i < params.length; i += 2) {
                typedQuery.setParameter(params[i].toString(), params[i + 1]);
            }
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Long getNewId(Class clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(clazz);
        Root root = cq.from(clazz);
        cq.select(cb.max(root.get("id")));
        TypedQuery q = em.createQuery(cq);
        Number maxId = ((Number) q.getSingleResult());
        return Objects.isNull(maxId) ? 1l : maxId.longValue() + 1l;
    }
}
