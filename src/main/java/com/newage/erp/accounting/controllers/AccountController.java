package com.newage.erp.accounting.controllers;

import javax.faces.view.ViewScoped;
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
public class AccountController extends SuperCRUDController<Account, AccountService> {
}
