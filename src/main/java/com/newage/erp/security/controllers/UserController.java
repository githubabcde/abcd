package com.newage.erp.security.controllers;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;

import com.newage.erp.common.controllers.SuperCRUDController;
import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.security.services.UserService;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class UserController extends SuperCRUDController<SecurityUser, UserService> {

    @Override
    public void create() {
        item.setPassword("123");
        super.create();
    }

    public void onTransfer(TransferEvent event) {
        event.getItems();
    }
}
