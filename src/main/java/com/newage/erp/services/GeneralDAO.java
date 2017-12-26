package com.newage.erp.services;

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
     * @param caller 
     */
    public void persist(Object e, Long caller);

    /**
     * 
     * @param e
     * @param caller 
     */
    public void merge(Object e, Long caller);

    /**
     * 
     * @param e
     * @param caller 
     */
    public void remove(Object e, Long caller);
    
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
