package com.newage.erp.security.services;

import com.newage.erp.common.services.SupperCRUDService;
import com.newage.erp.security.entities.SecurityUser;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

/**
 *
 * @author mohammed
 */
@Stateless
@DeclareRoles({"SecurityUser.create", "SecurityUser.remove", "SecurityUser.update", "SecurityUser.desplay"})
public class UserService extends SupperCRUDService<SecurityUser> {

    public UserService() {
        super(SecurityUser.class);
    }

    public SecurityUser findByUserNamePassword(String userName, String password) {
        return dao.findOne("SecurityUser.findByUserNamePassword", SecurityUser.class, "userName", userName, "password", password);
    }
}