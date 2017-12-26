package com.newage.erp.services.impl;

import com.newage.erp.services.GeneralDAO;
import java.util.List;
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
public class GeneralDAOImpl implements GeneralDAO {

    @PersistenceContext(unitName = "postgresPU")
    private EntityManager em;

    @Override
    public void persist(Object e, Long caller) {
        em.persist(e);
    }

    @Override
    public void merge(Object e, Long caller) {
        em.merge(e);
    }

    @Override
    public void remove(Object e, Long caller) {
        em.remove(e);
    }

    @Override
    public <T> List<T> find(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> rootEntry = cq.from(clazz);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public <T> T find(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    @Override
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
}
