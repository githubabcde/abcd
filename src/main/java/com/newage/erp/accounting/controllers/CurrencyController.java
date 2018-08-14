package com.newage.erp.accounting.controllers;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.newage.erp.accounting.entities.Currency;
import com.newage.erp.accounting.services.CurrencyService;
import com.newage.erp.common.controllers.SuperCRUDController;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class CurrencyController extends SuperCRUDController<Currency> {

    @Inject
    private CurrencyService currencyService;

    @PostConstruct
    private void init() {
        super.supperCRUDService = currencyService;
    }
}
