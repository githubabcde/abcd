package com.newage.erp.accounting.services;

import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

import com.newage.erp.accounting.entities.Transaction;
import com.newage.erp.accounting.entities.TransactionDetail;
import com.newage.erp.core.services.SuperCRUDService;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Stateless
@DeclareRoles({"Transaction.create", "Transaction.remove", "Transaction.update", "Transaction.desplay"})
public class TransactionService1 extends SuperCRUDService<Transaction> {

    @Inject
    private TransactionDetailService detailService;

    public TransactionService1() {
        super(Transaction.class);
    }

    public void create(Transaction transaction, List<TransactionDetail> details) {
        super.create(transaction);
        details.forEach(d -> {
            d.setTransaction(transaction);
            detailService.create(d);
        });
    }

    public void update(Transaction transaction, List<TransactionDetail> details) {
        super.update(transaction);
        details.forEach(d -> {
            if (Objects.isNull(d.getId())) {
                d.setTransaction(transaction);
                detailService.create(d);
            } else {
                detailService.update(d);
            }
        });
    }

    public void remove(Transaction transaction, List<TransactionDetail> details) {
        details.forEach(d -> {
            detailService.remove(d);
        });
        super.remove(transaction);
    }
}
