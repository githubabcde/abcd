package com.newage.erp.security.controllers;

import com.newage.erp.common.controllers.SuperCRUDController;
import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.security.services.UserService;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.TransferEvent;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class UserController extends SuperCRUDController<SecurityUser> {

    @Inject
    private UserService userService;

    @PostConstruct
    private void init() {
        super.supperCRUDService = userService;
    }

    @Override
    public void create() {
        item.setPassword("123");
        super.create();
    }

    public void onTransfer(TransferEvent event) {
        event.getItems();
    }
}
