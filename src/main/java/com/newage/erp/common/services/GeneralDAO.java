package com.newage.erp.common.services;

import com.newage.erp.common.entities.EntityMasterStamped;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mohammed
 */
@Local
public interface GeneralDAO {

    /**
     *
     * @param e
     * @param securityUser
     */
    public void persist(EntityMasterStamped e, Long securityUser);

    /**
     *
     * @param e
     * @param securityUser
     */
    public void merge(EntityMasterStamped e, Long securityUser);

    /**
     *
     * @param e
     * @param securityUser
     */
    public void remove(Object e, Long securityUser);

    /**
     *
     * @param <T>
     * @param clazz
     * @return
     */
    public <T> List<T> find(Class<T> clazz);

    /**
     *
     * @param <T>
     * @param clazz
     * @param id
     * @return
     */
    public <T> T find(Class<T> clazz, Long id);

    /**
     *
     * @param <T>
     * @param namedQuery
     * @param clazz
     * @param params
     * @return
     */
    public <T> List<T> find(String namedQuery, Class<T> clazz, Object... params);
}
