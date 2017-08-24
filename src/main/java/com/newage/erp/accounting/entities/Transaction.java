package com.newage.erp.accounting.entities;

import java.util.Date;

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
@Table(name = "TRANSACTION")
public class Transaction extends StampedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "TRANSACTION_TIME")
	private Date TransactionTime;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "TYPE")
	private Integer type;
	@ManyToOne
	@JoinColumn(name = "CURRENCY")
	private Currency currency;

	public Transaction() {
	}

	public Transaction(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTransactionTime() {
		return TransactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		TransactionTime = transactionTime;
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
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
