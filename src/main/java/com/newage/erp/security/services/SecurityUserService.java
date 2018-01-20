package com.newage.erp.security.services;

import com.newage.erp.common.services.DataAccessObject;
import com.newage.erp.security.entities.SecurityUser;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Stateless
public class SecurityUserService {

    @Inject
    protected DataAccessObject dao;

    @RolesAllowed("SecurityUser.list")
    public List<SecurityUser> find() {
        return dao.find(SecurityUser.class);
    }

    @RolesAllowed("SecurityUser.list")
    public SecurityUser find(Long id) {
        return dao.find(SecurityUser.class, id);
    }

    @RolesAllowed("SecurityUser.add")
    public void create(SecurityUser entity) {
        entity.setPassword("123");
        dao.persist(entity);
    }

    @RolesAllowed("SecurityUser.update")
    public void update(SecurityUser entity) {
        dao.merge(entity);
    }

    @RolesAllowed("SecurityUser.remove")
    public void remove(SecurityUser entity) {
        dao.remove(entity);
    }

    public SecurityUser findByUserNamePassword(String userName, String password) {
        return dao.findOne("SecurityUser.findByUserNamePassword", SecurityUser.class, "userName", userName, "password", password);
    }
}
