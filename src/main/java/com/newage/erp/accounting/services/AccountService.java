package com.newage.erp.accounting.services;

import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

import com.newage.erp.accounting.entities.Account;
import com.newage.erp.common.services.SuperCRUDService;

/**
 *
 * @author mohammed
 */
@Stateless
@DeclareRoles({"Account.create", "Account.remove", "Account.update", "Account.desplay"})
public class AccountService extends SuperCRUDService<Account> {

    public AccountService() {
        super(Account.class);
    }
}
