package com.newage.erp.accounting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.newage.erp.common.entities.StampedEntity;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "TRANSACTION_DETAIL")
public class TransactionDetail extends StampedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "AMOUNT")
	private Double amount;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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
