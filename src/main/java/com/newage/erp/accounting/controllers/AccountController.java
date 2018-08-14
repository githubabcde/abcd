package com.newage.erp.accounting.controllers;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.newage.erp.accounting.entities.Account;
import com.newage.erp.accounting.services.AccountService;
import com.newage.erp.common.controllers.SuperCRUDController;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class AccountController extends SuperCRUDController<Account> {

    @Inject
    private AccountService accountService;

    @PostConstruct
    private void init() {
        super.supperCRUDService = accountService;
    }
}
