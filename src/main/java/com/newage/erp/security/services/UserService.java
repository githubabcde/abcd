package com.newage.erp.security.services;

import com.newage.erp.common.services.SuperCRUDService;
import com.newage.erp.security.entities.SecurityUser;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

/**
 *
 * @author mohammed
 */
@Stateless
@DeclareRoles({"SecurityUser.create", "SecurityUser.remove", "SecurityUser.update", "SecurityUser.desplay"})
public class UserService extends SuperCRUDService<SecurityUser> {

    public UserService() {
        super(SecurityUser.class);
    }

    public SecurityUser findByUserNamePassword(String userName, String password) {
        return dataService.findOne("SecurityUser.findByUserNamePassword", SecurityUser.class, "userName", userName, "password", password);
    }
}
