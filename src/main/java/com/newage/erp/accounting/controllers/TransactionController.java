package com.newage.erp.accounting.controllers;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.newage.erp.accounting.entities.Currency;
import com.newage.erp.accounting.entities.Transaction;
import com.newage.erp.accounting.services.CurrencyService;
import com.newage.erp.accounting.services.TransactionService;
import com.newage.erp.core.controllers.SuperCRUDController;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class TransactionController extends SuperCRUDController<Transaction,TransactionService> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CurrencyService currencyService;
	
	public List<Currency> getCurrencies() {
		return currencyService.find();
	}
}
