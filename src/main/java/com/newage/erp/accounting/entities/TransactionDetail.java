package com.newage.erp.accounting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.newage.erp.core.entities.StampedNamedEntity;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "TRANSACTION_DETAIL")
public class TransactionDetail extends StampedNamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "DEBIT_AMOUNT")
	private Double debitAmount;
	@Column(name = "CREDIT_AMOUNT")
	private Double creditAmount;
	@Column(name = "TYPE")
	private Integer type;
	@ManyToOne
	@JoinColumn(name = "TRANSACTION")
	private Transaction transaction;
	@ManyToOne
	@JoinColumn(name = "ACCOUNT")
	private Account account;

	public TransactionDetail() {
	}

	public TransactionDetail(Long id) {
		super(id);
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
