package com.newage.erp.accounting.controllers;

import javax.faces.view.ViewScoped;
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
public class TransactionController extends SuperCRUDController<Transaction,TransactionService> {
}
