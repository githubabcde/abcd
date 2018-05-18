package com.newage.erp.security.controllers;

import com.newage.erp.common.controllers.SupperCRUDController;
import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.security.services.UserService;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class UserController extends SupperCRUDController<SecurityUser> {

    @Inject
    private UserService userService;

    @PostConstruct
    private void init() {
        super.clazz = SecurityUser.class;
        super.supperCRUDService = userService;
    }

    @Override
    public void create() {
        item.setPassword("123");
        super.create();
    }
}
