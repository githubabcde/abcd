package com.newage.erp.accounting.controllers;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.newage.erp.accounting.entities.Transaction;
import com.newage.erp.accounting.services.TransactionService;
import com.newage.erp.common.controllers.SuperCRUDController;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class TransactionController extends SuperCRUDController<Transaction> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TransactionService transactionService;

	@PostConstruct
	private void init() {
		super.supperCRUDService = transactionService;
	}
}
