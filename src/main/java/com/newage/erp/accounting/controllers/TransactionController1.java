package com.newage.erp.accounting.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.newage.erp.accounting.entities.Account;
import com.newage.erp.accounting.entities.Currency;
import com.newage.erp.accounting.entities.Transaction;
import com.newage.erp.accounting.entities.TransactionDetail;
import com.newage.erp.accounting.services.AccountService;
import com.newage.erp.accounting.services.CurrencyService;
import com.newage.erp.accounting.services.TransactionDetailService;
import com.newage.erp.accounting.services.TransactionService;
import com.newage.erp.accounting.services.TransactionService1;
import com.newage.erp.core.controllers.SuperCRUDController;
import static com.newage.erp.core.utli.Helper.addFacesMessage;
import javax.faces.application.FacesMessage;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class TransactionController1 extends SuperCRUDController<Transaction, TransactionService1> {

    private static final long serialVersionUID = 1L;

    private List<TransactionDetail> details;

    @Inject
    private CurrencyService currencyService;
    @Inject
    private AccountService accountService;
    @Inject
    private TransactionDetailService detalService;

    @Override
    public void prepareCreate() {
        super.prepareCreate();
        item.setType(1);
        details = new ArrayList<>();
        details.add(new TransactionDetail());
        details.add(new TransactionDetail());
    }

    @Override
    public void prepareUpdate(Long id) {
        super.prepareUpdate(id);
        details = detalService.findByTransaction(id);
    }

    @Override
    public void create() {
        service.create(item, details);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "saved");
        prepareCreate();
    }
    
    @Override
    public void update() {
        service.update(item, details);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "updated");
        item = null;
    }
    
    @Override
    public void remove() {
        service.remove(item, details);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "removed");
        item = null;
    }

    public List<Currency> getCurrencies() {
        return currencyService.find();
    }

    public List<Account> getAccounts() {
        return accountService.find();
    }

    public List<TransactionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TransactionDetail> details) {
        this.details = details;
    }
}
