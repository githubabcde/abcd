package com.newage.erp.security.services;

import com.newage.erp.common.services.SupperCRUDService;
import com.newage.erp.security.entities.SecurityUser;
import javax.ejb.Stateless;

/**
 *
 * @author mohammed
 */
@Stateless
public class UserService extends SupperCRUDService<SecurityUser> {

    public UserService() {
        super(SecurityUser.class);
    }

    public SecurityUser findByUserNamePassword(String userName, String password) {
        return dao.findOne("SecurityUser.findByUserNamePassword", SecurityUser.class, "userName", userName, "password", password);
    }
}
